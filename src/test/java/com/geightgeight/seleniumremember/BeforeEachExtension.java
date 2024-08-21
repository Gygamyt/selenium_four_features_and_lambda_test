package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.BrowserTypes;
import geightgeight.seleniumremember.driver.DriverManager;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class BeforeEachExtension implements BeforeEachCallback {
    private BrowserTypes browserType;

    public BeforeEachExtension() {
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        BrowserTypes browserType = (BrowserTypes) extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("browserType");
        WebDriver driver = DriverManager.getDriver(browserType);
        extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("driver", driver);
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
}
