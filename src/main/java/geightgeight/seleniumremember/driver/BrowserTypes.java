package geightgeight.seleniumremember.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserTypes {
    CHROME,
    FIREFOX,
    EDGE;

    public ChromeOptions getChromeOptions() {
        return CommonDriverOptions.getCommonChromeOptions();
    }

    public FirefoxOptions getFirefoxOptions() {
        return CommonDriverOptions.getCommonFirefoxOptions();
    }

    public EdgeOptions getEdgeOptions() {
        return CommonDriverOptions.getCommonEdgeOptions();
    }
}
