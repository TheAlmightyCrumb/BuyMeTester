package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import defaults.DriverSingleton;
import defaults.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WebPage implements CanInteract {
    private final WebDriver driver = DriverSingleton.getDriver();
    private final ExtentTest test;

    public WebPage(ExtentTest test) {
        this.test = test;
    }

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

    public List<WebElement> findWebElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch(NoSuchElementException e) {
            e.printStackTrace();
            test.fail(e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(Utils.getCurrentTimestamp() + "NoSuchElement", "png"))
                            .build());
        }
        return null;
    }

    private WebElement findWebElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch(NoSuchElementException e) {
            e.printStackTrace();
            test.fail(e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(Utils.getCurrentTimestamp() + "NoSuchElement", "png"))
                    .build());
        }
        return null;
    }
}
