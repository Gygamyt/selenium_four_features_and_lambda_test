package geightgeight.seleniumremember.driver.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static geightgeight.seleniumremember.driver.CommonDriverOptions.getCommonEdgeOptions;
import static geightgeight.seleniumremember.utils.ProcessKiller.saveProcessId;

public final class EdgeDriverFactory implements IWebDriver {
    @Override
    public WebDriver createDriver() {
        saveProcessId("msedgedriver");
        return new EdgeDriver(getCommonEdgeOptions());
    }
}
