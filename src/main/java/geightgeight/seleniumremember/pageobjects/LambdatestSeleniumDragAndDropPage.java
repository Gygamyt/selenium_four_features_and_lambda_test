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
//    @FindBy(xpath = "//*[@id='slider3']//h4[contains(text(), 'Default value 15')]/following-sibling::div//input[@type='range']")
//    private WebElement defaultValue15Slider;
//
//    @FindBy(xpath = "//*[@id='slider3']//h4[contains(text(), 'Default value 15')]/following-sibling::div//output[@id='rangeSuccess']")

    @FindBy(css = "input[value='15']")
    private WebElement sliderElement;

    @FindBy(css = "#rangeSuccess")
    private WebElement rangeSuccessElement;

    public String getTextRangeSuccessElement5() {
        return rangeSuccessElement.getText();
    }

    public LambdatestSeleniumDragAndDropPage slideTo95Value(int sliderValue) {
        Map<String, Integer> coordinates = getCoordinatesOfElement(sliderElement);

        actions.moveToElement(sliderElement, ((coordinates.get("x") * 10) / 100) + sliderValue, 0)
                .click()
                .build()
                .perform();

        return this;
    }

    public LambdatestSeleniumDragAndDropPage getCoordinatesOfSlider() {
        printCoordinates(sliderElement);
        System.out.println(sliderElement.getLocation().getX() + "x" + sliderElement.getLocation().getY());
        return this;
    }
}