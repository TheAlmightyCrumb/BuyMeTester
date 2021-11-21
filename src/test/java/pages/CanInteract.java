package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;

public interface CanInteract {
    void clickElement(By locator);
    void sendKeysToElement(By locator, String keys);
    boolean isElementEnabled(By locator);
    boolean isElementDisplayed(By locator);
    Rectangle getElementRect(By locator);
}
