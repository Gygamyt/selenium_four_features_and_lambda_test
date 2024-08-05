package geightgeight.seleniumremember.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserTypes implements DriverOptions {
    CHROME {
        @Override
        public ChromeOptions getChromeOptions() {
            ChromeOptions options = new ChromeOptions();
            return options;
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
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--window-size=1920x1080");
            return null;
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
            return null;
        }
    }
}
