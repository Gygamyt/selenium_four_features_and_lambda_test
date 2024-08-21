package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.BrowserTypes;
import geightgeight.seleniumremember.driver.DriverManager;
import geightgeight.seleniumremember.pageobjects.LambdaTestMainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static geightgeight.seleniumremember.utils.GeneratorOfRandomThings.generateSentence;

public class MessageTest extends BaseTest {

    @ParameterizedTest
    @EnumSource(BrowserTypes.class)
    public void messageTest(BrowserTypes browserType) {
        this.browserType = browserType;

        LambdaTestMainPage lambdaTestMainPage = new LambdaTestMainPage(DriverManager.getDriver());
        String userMsg = generateSentence(8);

        String appearedMessage = lambdaTestMainPage
                .acceptAllCookiesIfPanelExist()
                .clickSimpleFormDemoLinkElement()
                .enterUserMessage(userMsg)
                .getTextOfAppearedMessage();

        assertStringsEqual(appearedMessage, userMsg);
    }
}
