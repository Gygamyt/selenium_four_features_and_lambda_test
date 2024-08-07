package geightgeight.seleniumremember.pageobjects;

import geightgeight.seleniumremember.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        if (acceptAllCookies.isDisplayed()) {
            clickElement(acceptAllCookies);
        }
        return this;
    }

    public LambdatestSeleniumDragAndDropPage clickDragDropRangeLinkElement() {
        clickElement(dragDropRangeLinkElement);
        return new LambdatestSeleniumDragAndDropPage(DriverFactory.getDriver());
    }

    public LambdatestSeleniumSimpleFormDemoPage clickSimpleFormDemoLinkElement() {
        clickElement(simpleFormDemoLinkElement);
        return new LambdatestSeleniumSimpleFormDemoPage(DriverFactory.getDriver());
    }
}
