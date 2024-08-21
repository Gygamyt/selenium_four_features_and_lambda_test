package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public sealed interface IWebDriver permits ChromeDriverFactory, EdgeDriverFactory, ExplorerFactory, FirefoxDriverFactory {
    RemoteWebDriver createDriver() throws MalformedURLException, URISyntaxException;
}
