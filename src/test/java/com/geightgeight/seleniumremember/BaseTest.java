package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.BrowserTypes;
import geightgeight.seleniumremember.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static geightgeight.seleniumremember.utils.ProcessKiller.killProcessesUsingIds;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

//    @AfterAll
    public static void killDrivers() {
        killProcessesUsingIds();
    }

    public void assertStringsEqual(String actual, String expected) {
        assertEquals(expected, actual, "Strings are not equal (case-sensitive).");
    }
}
