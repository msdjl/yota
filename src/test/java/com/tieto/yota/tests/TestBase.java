package com.tieto.yota.tests;

import com.tieto.yota.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;
import static com.tieto.yota.util.Util.resetApp;

public class TestBase {
    MainPage page;

    @BeforeTest
    public void beforeTest() throws Exception {
        resetApp();
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        page = open("http://127.0.0.1:4567", MainPage.class);
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
            page.balanceBlock.reset();
    }
}
