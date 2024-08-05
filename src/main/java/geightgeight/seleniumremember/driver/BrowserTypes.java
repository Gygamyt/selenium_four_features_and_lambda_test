package geightgeight.seleniumremember.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserTypes implements DriverOptions {
    CHROME {
        @Override
        public ChromeOptions getChromeOptions() {
            return CommonDriverOptions.getCommonChromeOptions();
        }

        @Override
        public FirefoxOptions getFirefoxOptions() {
            return null;
        }

        @Override
        public EdgeOptions getEdgeOptions() {
            return null;
        }
    },
    FIREFOX {
        @Override
        public ChromeOptions getChromeOptions() {
            return null;
        }

        @Override
        public FirefoxOptions getFirefoxOptions() {
            return CommonDriverOptions.getCommonFirefoxOptions();
        }

        @Override
        public EdgeOptions getEdgeOptions() {
            return null;
        }
    },
    EDGE {
        @Override
        public ChromeOptions getChromeOptions() {
            return null;
        }

        @Override
        public FirefoxOptions getFirefoxOptions() {
            return null;
        }

        @Override
        public EdgeOptions getEdgeOptions() {
            return CommonDriverOptions.getCommonEdgeOptions();
        }
    }
}
