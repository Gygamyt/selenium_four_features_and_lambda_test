package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.DriverFactory;
import geightgeight.seleniumremember.pageobjects.LambdaTestMainPage;
import geightgeight.seleniumremember.utils.GeneratorOfRandomThings;
import org.junit.jupiter.api.Test;

public class TestForTests extends BaseTest {

    @Test
    public void testScenarioFirst() {
        LambdaTestMainPage lambdaTestMainPage = new LambdaTestMainPage(DriverFactory.getDriver());
        DriverFactory.getDriver().get("https://www.lambdatest.com/selenium-playground/");
        String userMsg = GeneratorOfRandomThings.generateSentence(8);

        String appearedMessage = lambdaTestMainPage
                .acceptAllCookiesIfPanelExist()
                .clickSimpleFormDemoLinkElement()
                .enterUserMessage(userMsg)
                .getTextOfAppearedMessage();

        assertStringsEqual(appearedMessage, userMsg);
    }

    @Test
    public void testScenarioSecond() throws InterruptedException {
        LambdaTestMainPage lambdaTestMainPage = new LambdaTestMainPage(DriverFactory.getDriver());
        DriverFactory.getDriver().get("https://www.lambdatest.com/selenium-playground/");

        lambdaTestMainPage
                .acceptAllCookiesIfPanelExist()
                .clickDragDropRangeLinkElement()
                .slideTo95Value();
    }
}
