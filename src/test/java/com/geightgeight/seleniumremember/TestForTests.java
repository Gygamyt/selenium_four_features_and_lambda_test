package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.DriverFactory;
import geightgeight.seleniumremember.pageobjects.ChooseSearchEnginePage;
import org.junit.jupiter.api.Test;

public class TestForTests extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        ChooseSearchEnginePage searchEnginePage = new ChooseSearchEnginePage(DriverFactory.getDriver());
        DriverFactory.getDriver().get("https://www.lambdatest.com/selenium-playground/");
        searchEnginePage.chooseGoogleAsSearchEngine();
        Thread.sleep(80000);
    }
}
