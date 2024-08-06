package geightgeight.seleniumremember.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.lambdatest.com/selenium-playground/
public class LambdaTestMainPage {
    public LambdaTestMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement acceptAllCookies;

    @FindBy(xpath = "//a[contains(@href, 'simple-form-demo')]")
    private WebElement simpleFormDemoLinkElement;

    @FindBy(css = "input[id='user-message']")
    private WebElement enterUserMessageField;

}