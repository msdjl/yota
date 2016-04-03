package com.tieto.yota.pages;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class TariffConditionsBlock extends ElementsContainer {
    @FindBy(css = ".header-container > h3")
    public SelenideElement header;

    @FindBy(css = ".time > strong")
    public SelenideElement daysLeft;

    @FindBy(css = ".speed > strong")
    public SelenideElement speed;

    @FindBy(css = ".speed > span")
    public SelenideElement speedLabel;

    @FindBy(css = ".cost > strong")
    public SelenideElement cost;
}