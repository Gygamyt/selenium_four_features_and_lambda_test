package geightgeight.seleniumremember.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.ConcurrentHashMap;

public class CommonDriverOptions {

    private static final ConcurrentHashMap<String, Object> ltOptions = new ConcurrentHashMap<>() {
    };

    static {
        ltOptions.put("username", "gygamyt");
        ltOptions.put("accessKey", "g9HzIFANhVTxSzKTV5i2spCsPuB76U8v2zptIwhqClOsqJFuh4");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
    }

    public static ChromeOptions getCommonChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-first-run");
        options.setBrowserVersion("88.0");
        options.setPlatformName("Windows 10");
        options.setCapability("LT:Options", ltOptions);
        return options;
    }

    public static FirefoxOptions getCommonFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName("macOS Sierra");
        options.setBrowserVersion("87");
        options.setCapability("LT:Options", ltOptions);
        return options;
    }

    public static EdgeOptions getCommonEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.setPlatformName("Windows 7");
        options.setBrowserVersion("82");
        options.setCapability("LT:Options", ltOptions);
        return options;
    }

    public static InternetExplorerOptions getCommonExplorerOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("11");
        options.setCapability("LT:Options", ltOptions);
        return options;
    }
}
