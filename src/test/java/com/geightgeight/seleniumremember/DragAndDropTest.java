package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.BrowserTypes;
import geightgeight.seleniumremember.driver.DriverManager;
import geightgeight.seleniumremember.pageobjects.LambdaTestMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class DragAndDropTest {

    @ParameterizedTest
    @EnumSource(BrowserTypes.class)
    public void dragAndDrop() {
        LambdaTestMainPage lambdaTestMainPage = new LambdaTestMainPage(DriverManager.getDriver());

        var lambdatestSeleniumDragAndDropPage = lambdaTestMainPage
                .acceptAllCookiesIfPanelExist()
                .clickDragDropRangeLinkElement()
                .getCoordinatesOfSlider();

        int i = 29;

        while (!lambdatestSeleniumDragAndDropPage.getTextRangeSuccessElement5().equals("95")) {
            i = i + 1;
            lambdatestSeleniumDragAndDropPage.slideTo95Value(i);
//            lambdatestSeleniumDragAndDropPage.getCoordinatesOfSlider();
        }

        Assertions.assertEquals("95", lambdatestSeleniumDragAndDropPage.getTextRangeSuccessElement5());
    }
}
