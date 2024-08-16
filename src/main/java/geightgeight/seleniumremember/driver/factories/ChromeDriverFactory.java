package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.getCommonChromeOptions;
import static geightgeight.seleniumremember.utils.ProcessKiller.saveProcessId;

public final class ChromeDriverFactory implements IWebDriver {
    @Override
    public WebDriver createDriver() {
        saveProcessId("chromedriver");
        return new ChromeDriver(getCommonChromeOptions());
    }
}
