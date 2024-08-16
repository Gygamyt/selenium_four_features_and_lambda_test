package geightgeight.seleniumremember.driver;

import geightgeight.seleniumremember.logging.ILogger;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static geightgeight.seleniumremember.driver.factories.DriverFactory.fullySetUpDriver;
import static geightgeight.seleniumremember.logging.ILogger.getStaticLogger;

public class DriverManager implements ILogger {
    private static volatile WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (DriverManager.class) {
                if (driver == null) {
                    throw new IllegalStateException("You must initialize driver first.");
                }
            }
        }
        return driver;
    }

    public static WebDriver getDriver(BrowserTypes browserType) {
        if (driver == null) {
            synchronized (DriverManager.class) {
                if (driver == null) {
                    driver = fullySetUpDriver(browserType.toString().toLowerCase());
                }
                setUpImplicitlyWait(driver, 5);
                getStaticLogger(DriverManager.class)
                        .info("Initialized WebDriver using {}", browserType);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            try {
                DriverManager.getDriver().close();
                getStaticLogger(DriverManager.class)
                        .info("Driver closed");
            } catch (Exception e) {
                getStaticLogger(DriverManager.class)
                        .error("{}/n{}", e.getMessage(), "Driver might not be closed");
                System.out.println("Driver ne ybit bratik");
            } finally {
                driver = null;
            }
        }
    }

    private static <T extends WebDriver> void setUpImplicitlyWait(T driver, int duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));

        getStaticLogger(DriverManager.class)
                .info("Implicitly wait for {} seconds", duration);
    }
}
