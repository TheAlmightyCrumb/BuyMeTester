package pages;

import com.aventstack.extentreports.ExtentTest;
import defaults.Constants;
import defaults.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class HomePage extends WebPage {

    private final Random rand = new Random();
    private final WebDriver driver = DriverSingleton.getDriver();

    public HomePage(ExtentTest test) {
        super(test);
    }

    public String getPageMatch() {
        return "/";
    }

    public void pickOptionsFromSelects() {
        List<WebElement> selects = findWebElements(Constants.FILTERS_SELECTS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll(\"" + Constants.FILTERS_SELECTS_CSS_LOCATOR + "\").forEach(elem => { elem.style.display = \"initial\" });");
        for (WebElement selectElement: selects) {
            System.out.println(selectElement.isDisplayed());
            Select selectObject = new Select(selectElement);
            int randomIndex = rand.nextInt(selectObject.getOptions().size() - 1) + 1;
            selectObject.selectByIndex(randomIndex);
        }
    }

    public void clickFindGift() {
        clickElement(Constants.FIND_GIFT_BUTTON);
    }
}
