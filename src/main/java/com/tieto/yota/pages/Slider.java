package com.tieto.yota.pages;

import com.codeborne.selenide.ElementsContainer;

public class Slider extends ElementsContainer {
    public void moveLeft() {
        getSelf().$(".decrease > a").click();
    }

    public void moveRight() {
        getSelf().$(".increase > a").click();
    }
}