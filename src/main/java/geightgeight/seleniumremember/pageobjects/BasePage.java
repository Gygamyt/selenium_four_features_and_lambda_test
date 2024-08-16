package geightgeight.seleniumremember.pageobjects;

import geightgeight.seleniumremember.driver.DriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class BasePage {

    public WebDriverWait waiter;

    public Actions actions;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.waiter = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        this.actions = new Actions(DriverManager.getDriver());
    }

    public void clickElement(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }

    private void waitUntilClickable(WebElement element) {
        waiter.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public Map<String, Integer> getCoordinatesOfElement(WebElement element) {
        Point point = element.getLocation();

        Integer x = point.getX();
        Integer y = point.getY();

        Map<String, Integer> coordinates = new HashMap<>();
        coordinates.put("x", x);
        coordinates.put("y", y);
        return coordinates;
    }

    public void printCoordinates(WebElement element) {
        var coordinates = getCoordinatesOfElement(element);
        System.out.println(coordinates.get("x") + " x\n" + coordinates.get("y") + "y");
    }

    public void getCurrentLink () {
        DriverManager.getDriver().getCurrentUrl();
    }
}
