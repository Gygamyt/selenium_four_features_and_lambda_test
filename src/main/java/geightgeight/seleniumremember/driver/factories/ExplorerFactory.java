package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.getCommonExplorerOptions;
import static geightgeight.seleniumremember.driver.factories.DriverFactory.getRemoteUrl;

public final class ExplorerFactory implements IWebDriver {

    @Override
    public RemoteWebDriver createDriver() throws MalformedURLException, URISyntaxException {
        return new RemoteWebDriver(getRemoteUrl(), getCommonExplorerOptions());
    }
}
