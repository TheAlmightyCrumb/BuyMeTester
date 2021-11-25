package pages;

import com.aventstack.extentreports.ExtentTest;
import defaults.Constants;
import org.openqa.selenium.Rectangle;

public class LoadingPage extends WebPage {

    public LoadingPage(ExtentTest test) {
        super(test);
    }

    public void printSpinnerSize() {
        Rectangle sizes = getElementRect(Constants.LOADING_SPINNER_DOT);
        System.out.println("Dot's height: " + sizes.getHeight() + ", and width: " + sizes.getWidth());
    }
}
