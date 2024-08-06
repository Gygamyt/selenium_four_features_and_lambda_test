package geightgeight.seleniumremember.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ChooseSearchEnginePage extends BasePage {
    public ChooseSearchEnginePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='search-engine-name' and text()='google']")
    private WebElement searchEngineGoogle;

    @FindBy(css = "#actionButton")
    private WebElement applyButton;

    public void chooseGoogleAsSearchEngine() {
        clickElement(searchEngineGoogle);
        clickElement(applyButton);
    }
}
