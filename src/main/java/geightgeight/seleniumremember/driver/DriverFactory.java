package geightgeight.seleniumremember.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static volatile WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver(BrowserTypes browserType) {
        if (driver == null) {
            synchronized (DriverFactory.class) {
                if (driver == null) {
                    switch (browserType) {
                        case CHROME:
                            driver = new ChromeDriver();
                            break;
                        case FIREFOX:
                            driver = new FirefoxDriver();
                            break;
                        case EDGE:
                            driver = new EdgeDriver();
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported browser type: " + browserType);
                    }
                }
            }
        }
        return driver;
    }


}
