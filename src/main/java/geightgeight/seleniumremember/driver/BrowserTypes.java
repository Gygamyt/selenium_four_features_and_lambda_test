package geightgeight.seleniumremember.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.*;

public enum BrowserTypes {
    CHROME,
    FIREFOX,
    EDGE;

    public ChromeOptions getChromeOptions() {
        return getCommonChromeOptions();
    }

    public FirefoxOptions getFirefoxOptions() {
        return getCommonFirefoxOptions();
    }

    public EdgeOptions getEdgeOptions() {
        return getCommonEdgeOptions();
    }
}
