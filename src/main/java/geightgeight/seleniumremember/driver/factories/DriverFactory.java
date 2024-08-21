package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverFactory {

    private static final String USERNAME = "gygamyt";
    private static final String ACCESSKEY = "g9HzIFANhVTxSzKTV5i2spCsPuB76U8v2zptIwhqClOsqJFuh4";
    private static final String gridURL = "@hub.lambdatest.com/wd/hub";

    public static URL getRemoteUrl() throws URISyntaxException, MalformedURLException {
        URI uri = new URI("https://" + USERNAME + ":" + ACCESSKEY + gridURL);
        return uri.toURL();
    }

    public static RemoteWebDriver fullySetUpDriver(String browserName) throws MalformedURLException, URISyntaxException {
        return switch (browserName.toLowerCase()) {
            case "chrome" -> new ChromeDriverFactory().createDriver();
            case "firefox" -> new FirefoxDriverFactory().createDriver();
            case "edge" -> new EdgeDriverFactory().createDriver();
            case "explorer" -> new ExplorerFactory().createDriver();
            default -> throw new IllegalStateException("Unexpected value: " + browserName.toLowerCase());
        };
    }
}
