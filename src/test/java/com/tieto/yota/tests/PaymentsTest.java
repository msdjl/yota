package com.tieto.yota.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.refresh;

public class PaymentsTest extends TestBase {
    @Test(description = "balance should be 0 by default")
    public void testBalanceByDefault() throws Exception {
        page.balanceBlock.balance.shouldHave(text("0"));
    }

    @Test(description = "it should be possible to perform payment with positive value")
    public void testPositivePayment() throws Exception {
        page.balanceBlock.paymentInput.val("1234");
        page.balanceBlock.performPayment();
        page.balanceBlock.balance.shouldHave(text("1234"));
    }

    @Test(description = "balance shouldn't be reset after page refreshing")
    public void testBalanceAfterPageRefresh() throws Exception {
        page.balanceBlock.paymentInput.val("1234");
        page.balanceBlock.performPayment();
        refresh();
        page.balanceBlock.balance.shouldHave(text("1234"));
    }

    @Test(description = "it should be impossible to perform payment with negative value (balance can't be less than 0)")
    public void testNegativePayment() throws Exception {
        page.balanceBlock.paymentInput.val("-1");
        page.balanceBlock.performPayment();
        page.balanceBlock.balance.shouldHave(text("0"));
    }

    @Test(description = "it should be possible to perform payments few times")
    public void testMultiplyPayments() throws Exception {
        page.balanceBlock.paymentInput.val("1");
        page.balanceBlock.performPayment();
        page.balanceBlock.paymentInput.val("10");
        page.balanceBlock.performPayment();
        page.balanceBlock.paymentInput.val("100");
        page.balanceBlock.performPayment();
        page.balanceBlock.balance.shouldHave(text("111"));
    }
}
