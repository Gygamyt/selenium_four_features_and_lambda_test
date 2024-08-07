package geightgeight.seleniumremember.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = https://www.lambdatest.com/selenium-playground/simple-form-demo
public class LambdatestSeleniumSimpleFormDemoPage extends BasePage {
    public LambdatestSeleniumSimpleFormDemoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='user-message']")
    private WebElement enterUserMessageField;

    @FindBy(xpath = "//*[@id='showInput']")
    private WebElement getCheckedValueButton;

    @FindBy(xpath = "//*[@id='message']")
    private WebElement appearedUserMessageText;

    @FindBy(xpath = "//*[@id='user-message'][.//*[@id='message']]")
    private WebElement appearedUserMessageButForMoreCarefulCheck;

    public LambdatestSeleniumSimpleFormDemoPage enterUserMessage(String message) {
        clickElement(enterUserMessageField);
        enterText(enterUserMessageField, message);
        clickElement(getCheckedValueButton);
        return this;
    }

    public String getTextOfAppearedMessage() {
        return getText(appearedUserMessageText);
    }
}