package geightgeight.seleniumremember.pageobjects;

import geightgeight.seleniumremember.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// page_url = https://www.lambdatest.com/selenium-playground/
public class LambdaTestMainPage extends BasePage {
    public LambdaTestMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement acceptAllCookies;

    @FindBy(xpath = "//a[contains(@href, 'simple-form-demo')]")
    private WebElement simpleFormDemoLinkElement;

    @FindBy(xpath = "//a[contains(@href, 'drag-drop-range')]")
    private WebElement dragDropRangeLinkElement;

    public LambdaTestMainPage acceptAllCookiesIfPanelExist() {
        waiter.until(ExpectedConditions.elementToBeClickable(acceptAllCookies));
        acceptAllCookies.click();
        return this;
    }

    public LambdatestSeleniumDragAndDropPage clickDragDropRangeLinkElement() {
        clickElement(dragDropRangeLinkElement);
        return new LambdatestSeleniumDragAndDropPage(DriverManager.getDriver());
    }

    public LambdatestSeleniumSimpleFormDemoPage clickSimpleFormDemoLinkElement() {
        clickElement(simpleFormDemoLinkElement);
        return new LambdatestSeleniumSimpleFormDemoPage(DriverManager.getDriver());
    }
}
