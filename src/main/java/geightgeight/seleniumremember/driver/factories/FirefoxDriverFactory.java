package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.getCommonFirefoxOptions;
import static geightgeight.seleniumremember.driver.factories.DriverFactory.getRemoteUrl;
import static geightgeight.seleniumremember.utils.ProcessKiller.saveProcessId;

public final class FirefoxDriverFactory implements IWebDriver {
    @Override
    public RemoteWebDriver createDriver() throws MalformedURLException, URISyntaxException {
        saveProcessId("geckodriver");
        return new RemoteWebDriver(getRemoteUrl(), getCommonFirefoxOptions());
    }
}
