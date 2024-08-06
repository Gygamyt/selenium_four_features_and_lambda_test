package geightgeight.seleniumremember.driver;

import geightgeight.seleniumremember.logging.ILogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory implements ILogger {
    private static volatile WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (DriverFactory.class) {
                if (driver == null) {
                    throw new IllegalStateException("You must initialize driver first.");
                }
            }
        }
        return driver;
    }

    public static WebDriver getDriver(BrowserTypes browserType) {
        if (driver == null) {
            synchronized (DriverFactory.class) {
                if (driver == null) {
                    switch (browserType) {
                        case CHROME:
//                            WebDriverManager.chromedriver().setup();
                            driver = new ChromeDriver(browserType.getChromeOptions());
                            break;
                        case FIREFOX:
                            WebDriverManager.firefoxdriver().setup();
                            driver = new FirefoxDriver(browserType.getFirefoxOptions());
                            break;
                        case EDGE:
                            WebDriverManager.edgedriver().setup();
                            driver = new EdgeDriver(browserType.getEdgeOptions());
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported browser type: " + browserType);
                    }
                    setUpImplicitlyWait(driver, 5);
                    ILogger.getStaticLogger(DriverFactory.class)
                            .info("Initialized WebDriver using {}", browserType);
                }
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (DriverFactory.getDriver() != null) {
            try {
                DriverFactory.getDriver().quit();
                ILogger.getStaticLogger(DriverFactory.class)
                        .info("Driver closed");
            } catch (Exception e) {
                ILogger.getStaticLogger(DriverFactory.class)
                        .error("{}/n{}", e.getMessage(), "Driver might not be closed");
                System.out.println("Driver ne ybit bratik");
            } finally {
                driver = null;
            }
        }
    }

    private static <T extends WebDriver> void setUpImplicitlyWait(T driver, int duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
        ILogger.getStaticLogger(DriverFactory.class)
                .info("Implicitly wait for {} seconds", duration);
    }
}
