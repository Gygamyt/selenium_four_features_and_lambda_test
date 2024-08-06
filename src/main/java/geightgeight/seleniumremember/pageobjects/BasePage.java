package geightgeight.seleniumremember.pageobjects;

import geightgeight.seleniumremember.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public WebDriverWait waiter;

    public Actions actions;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.waiter = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        this.actions = new Actions(DriverFactory.getDriver());
    }

    public void clickElement(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }

    private void waitUntilClickable(WebElement element) {
        waiter.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void getCurrentLink () {
        DriverFactory.getDriver().getCurrentUrl();
    }
}
