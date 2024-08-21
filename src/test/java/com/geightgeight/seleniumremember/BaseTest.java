package com.geightgeight.seleniumremember;

import geightgeight.seleniumremember.driver.BrowserTypes;
import geightgeight.seleniumremember.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static geightgeight.seleniumremember.utils.ProcessKiller.killProcessesUsingIds;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith({BeforeEachExtension.class, CustomParameterResolver.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected BrowserTypes browserType;

    @BeforeEach
    public void setUp(BrowserTypes browserType) throws MalformedURLException, URISyntaxException {
        driver = DriverManager.getDriver(browserType);
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterEach
    public void tearDown() {
        DriverManager.closeDriver();
    }

//    @AfterAll
    public static void killDrivers() {
        killProcessesUsingIds();
    }

    public void assertStringsEqual(String actual, String expected) {
        assertEquals(expected, actual, "Strings are not equal (case-sensitive).");
    }
}
