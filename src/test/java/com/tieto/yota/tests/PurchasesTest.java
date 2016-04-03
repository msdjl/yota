package com.tieto.yota.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.refresh;

public class PurchasesTest extends TestBase {
    private String firstNonFreeTariffCost;

    @BeforeClass
    public void beforeClass() throws Exception {
        super.beforeClass();
        page.slider.moveRight();
        this.firstNonFreeTariffCost = page.newTariffBlock.cost.text();
    }

    @Test(description = "free tariff should be applied by default")
    public void testDefaultTariff() throws Exception {
        page.currentTariffBlock.cost.shouldHave(text("0"));
    }

    @Test(description = "free tariff should be applied by default after page refreshing")
    public void testDefaultTariffAfterPageRefresh() throws Exception {
        page.balanceBlock.paymentInput.val(firstNonFreeTariffCost);
        page.balanceBlock.performPayment();
        page.slider.moveRight();
        page.newTariffBlock.applyTariff();
        refresh();
        page.currentTariffBlock.cost.shouldHave(text("0"));
    }

    @Test(description = "it should be impossible to apply new tariff if balance is less than tariff cost")
    public void testBuyingTariffWithoutMoney() throws Exception {
        page.slider.moveRight();
        page.newTariffBlock.applyTariff();
        page.currentTariffBlock.cost.shouldHave(text("0"));
    }

    @Test(description = "it should be possible to apply new tariff if balance is enough to")
    public void testBuyingTariffWithEnoughMoney() throws Exception {
        page.balanceBlock.paymentInput.val(firstNonFreeTariffCost);
        page.balanceBlock.performPayment();
        page.slider.moveRight();
        page.newTariffBlock.applyTariff();
        page.currentTariffBlock.cost.shouldHave(text(firstNonFreeTariffCost));
    }

    @Test(description = "balance should decrease when new tariff is applied")
    public void testBalanceDecreasing() throws Exception {
        String newBalanceValue = String.valueOf(9999 - Integer.decode(firstNonFreeTariffCost));
        page.balanceBlock.paymentInput.val("9999");
        page.balanceBlock.performPayment();
        page.slider.moveRight();
        page.newTariffBlock.applyTariff();
        page.balanceBlock.balance.shouldHave(text(newBalanceValue));
    }

    @Test(description = "it should be possible to apply free tariff")
    public void testBuyingFreeTariffWithoutMoney() throws Exception {
        page.balanceBlock.paymentInput.val(firstNonFreeTariffCost);
        page.balanceBlock.performPayment();
        page.slider.moveRight();
        page.newTariffBlock.applyTariff();
        page.slider.moveLeft();
        page.newTariffBlock.applyTariff();
        page.currentTariffBlock.cost.shouldHave(text("0"));
    }
}
