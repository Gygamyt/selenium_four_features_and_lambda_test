package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.WebDriver;

public sealed interface IWebDriver permits ChromeDriverFactory, EdgeDriverFactory, FirefoxDriverFactory {
    WebDriver createDriver();
}
