package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.getCommonEdgeOptions;
import static geightgeight.seleniumremember.driver.factories.DriverFactory.getRemoteUrl;
import static geightgeight.seleniumremember.utils.ProcessKiller.saveProcessId;

public final class EdgeDriverFactory implements IWebDriver {
    @Override
    public RemoteWebDriver createDriver() throws MalformedURLException, URISyntaxException {
        saveProcessId("msedgedriver");
        return new RemoteWebDriver(getRemoteUrl(), getCommonEdgeOptions());
    }
}
