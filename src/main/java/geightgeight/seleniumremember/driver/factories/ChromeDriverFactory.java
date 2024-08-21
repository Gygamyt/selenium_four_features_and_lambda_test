package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.getCommonChromeOptions;
import static geightgeight.seleniumremember.driver.factories.DriverFactory.getRemoteUrl;
import static geightgeight.seleniumremember.utils.ProcessKiller.saveProcessId;

public final class ChromeDriverFactory implements IWebDriver {
    @Override
    public RemoteWebDriver createDriver() throws MalformedURLException, URISyntaxException {
        saveProcessId("chromedriver");
        return new RemoteWebDriver(getRemoteUrl(),getCommonChromeOptions());
    }
}
