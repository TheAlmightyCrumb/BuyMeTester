package pages;

import defaults.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPage implements CanInteract {
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

    public String getElementText(By locator) {
        return findWebElement(locator).getText();
    }

    public String getElementValue(By locator) {
        return findWebElement(locator).getAttribute("value");
    }

    public Rectangle getElementRect(By locator) {
        return findWebElement(locator).getRect();
    }

    private WebElement findWebElement(By locator) {
        return driver.findElement(locator);
    }
}
