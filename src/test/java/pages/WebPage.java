package pages;

import defaults.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPage {
    private WebDriver driver = DriverSingleton.getInstance();

    public void clickElement(By locator) {
        findWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String keys) {
        findWebElement(locator).sendKeys(keys);
    }

    public boolean isElementEnabled(By locator) {
        return findWebElement(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

    public Rectangle getElementsRect(By locator) {
        return findWebElement(locator).getRect();
    }

    private WebElement findWebElement(By locator) {
        return driver.findElement(locator);
    }
}
