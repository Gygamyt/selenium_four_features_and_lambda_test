package geightgeight.seleniumremember.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

// page_url = https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo
public class LambdatestSeleniumDragAndDropPage extends BasePage {
    public LambdatestSeleniumDragAndDropPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Да, я обязательно сделаю лучше.
     */
    @FindBy(xpath = "//*[@id='slider3']//h4[contains(text(), 'Default value 15')]/following-sibling::div//input[@type='range']")
    private WebElement defaultValue15Slider;

    @FindBy(xpath = "//*[@id='slider3']//h4[contains(text(), 'Default value 15')]/following-sibling::div//output[@id='rangeSuccess']")
    private WebElement defaultValue15Result;

    public String getTextOfSliderWithDefaultValue15() {
        return defaultValue15Slider.getText();
    }

    public LambdatestSeleniumDragAndDropPage slideTo95Value() {
        Map<String, Integer> coordinates = getCoordinatesOfElement(defaultValue15Slider);

        String result;

        do {
            actions
                    .clickAndHold(defaultValue15Slider)
                    .moveToLocation(coordinates.get("x"), coordinates.get("y"))
                    .perform();

            coordinates.put("x", coordinates.get("x") + 1);
            result = getText(defaultValue15Result);
        } while (!result.equals("95"));

        return this;
    }
}