package geightgeight.seleniumremember.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

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
                            WebDriverManager.chromedriver().setup();
                            driver = new ChromeDriver(browserType.getChromeOptions());
                            setUpImplicitlyWait(driver);
                            break;
                        case FIREFOX:
                            WebDriverManager.firefoxdriver().setup();
                            driver = new FirefoxDriver(browserType.getFirefoxOptions());
                            setUpImplicitlyWait(driver);
                            break;
                        case EDGE:
                            WebDriverManager.edgedriver().setup();
                            driver = new EdgeDriver(browserType.getEdgeOptions());
                            setUpImplicitlyWait(driver);
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported browser type: " + browserType);
                    }
                }
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static <T extends WebDriver> void setUpImplicitlyWait(@NotNull T driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
