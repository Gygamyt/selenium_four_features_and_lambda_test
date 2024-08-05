package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.BrowserTypes;
import geightgeight.seleniumremember.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    private BrowserTypes browserType;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser_type");

        if (browser == null) {
            browser = "chrome";
        }

        try {
            browserType = BrowserTypes.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown browser type: " + browser);
        }

        driver = DriverFactory.getDriver(browserType);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
