package com.tieto.yota.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.tieto.yota.util.Util.waitForJQuery;

public class NewTariffConditionsBlock extends TariffConditionsBlock {
    @FindBy(css = ".tarriff-info > a")
    public SelenideElement applyTariffButton;

    public void applyTariff() {
        applyTariffButton.click();
        waitForJQuery();
    }
}