package pages;

import defaults.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class WebPage implements CanInteract {
    private WebDriver driver = DriverSingleton.getDriver();

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

    public String takeScreenshot(String filePath, String format) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(filePath + "." + format);
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return destinationFile.getName();
    }

    private WebElement findWebElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch(NoSuchElementException e) {
        }
        return null;
    }
}
