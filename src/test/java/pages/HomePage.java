package pages;

import com.aventstack.extentreports.ExtentTest;
import defaults.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class HomePage extends WebPage {

    private final Random rand = new Random();

    public HomePage(ExtentTest test) {
        super(test);
    }

    public void pickOptionsFromSelects(boolean random) {
        List<WebElement> selects = findWebElements(Constants.FILTERS_SELECTS);
        executeJavaScript("document.querySelectorAll(\"" + Constants.FILTERS_SELECTS_CSS_LOCATOR + "\").forEach(elem => { elem.style.display = \"initial\" });");
        for (WebElement selectElement: selects) {
            Select selectObject = new Select(selectElement);
            int randomIndex = rand.nextInt(selectObject.getOptions().size() - 1) + 1;
            if (random)
                selectObject.selectByIndex(randomIndex);
            else
                selectObject.selectByIndex(2);
        }
    }

    public void clickFindGift() {
        clickElement(Constants.FIND_GIFT_BUTTON);
    }
}
