package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.getCommonFirefoxOptions;
import static geightgeight.seleniumremember.utils.ProcessKiller.saveProcessId;

public final class FirefoxDriverFactory implements IWebDriver {
    @Override
    public WebDriver createDriver() {
        saveProcessId("geckodriver");
        return new FirefoxDriver(getCommonFirefoxOptions());
    }
}
