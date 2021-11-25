package pages;

import com.aventstack.extentreports.ExtentTest;
import defaults.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends WebPage{

    public ResultsPage(ExtentTest test) {
        super(test);
    }

    public ArrayList<String> getOptionsValuesFromSelects() {
        List<WebElement> selects = findWebElements(Constants.FILTERS_SELECTS);
        executeJavaScript("document.querySelectorAll(\"" + Constants.FILTERS_SELECTS_CSS_LOCATOR + "\").forEach(elem => { elem.style.display = \"initial\" });");
        ArrayList<String> chosenValues = new ArrayList<>();
        for (WebElement selectElement: selects) {
            Select selectObject = new Select(selectElement);
            String chosenOptionValue = selectObject.getFirstSelectedOption().getAttribute("value");
            chosenValues.add(chosenOptionValue);
        }
        return chosenValues;
    }

    public void clickBusinessCard() {
        clickElement(Constants.BUSINESS_CARD);
    }

}
