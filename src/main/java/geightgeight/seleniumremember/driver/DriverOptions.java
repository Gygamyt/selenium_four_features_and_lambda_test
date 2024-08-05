package geightgeight.seleniumremember.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public interface DriverOptions {
    ChromeOptions getChromeOptions();

    FirefoxOptions getFirefoxOptions();

    EdgeOptions getEdgeOptions();
}
