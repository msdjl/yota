package com.tieto.yota.pages;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.tieto.yota.util.Util.waitForJQuery;

public class BalanceBlock extends ElementsContainer {
    @FindBy(css = "#balance-holder > span")
    public SelenideElement balance;

    @FindBy(css = "#amount")
    public SelenideElement paymentInput;

    public void performPayment() {
        getSelf().$(".actions > a[data-bind*=doPayment]").click();
        waitForJQuery();
    }

    public void reset() {
        getSelf().$(".actions > a[data-bind*=doReset]").click();
        waitForJQuery();
    }
}