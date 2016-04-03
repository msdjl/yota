package com.tieto.yota.pages;

import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(css = ".hint-inner")
    public TariffConditionsBlock currentTariffBlock;

    @FindBy(css = ".main-offer-container")
    public NewTariffConditionsBlock newTariffBlock;

    @FindBy(css = ".slider-container")
    public Slider slider;

    @FindBy(css = ".account-money")
    public BalanceBlock balanceBlock;
}