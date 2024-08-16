package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver fullySetUpDriver(String browserName) {
        return switch (browserName.toLowerCase()) {
            case "chrome" -> new ChromeDriverFactory().createDriver();
            case "firefox" -> new FirefoxDriverFactory().createDriver();
            case "edge" -> new EdgeDriverFactory().createDriver();
            default -> throw new IllegalStateException("Unexpected value: " + browserName.toLowerCase());
        };
    }
}
