package pages;

import com.aventstack.extentreports.ExtentTest;
import defaults.Constants;

public class BusinessPage extends WebPage{

    public BusinessPage(ExtentTest test) {
        super(test);
    }

    public boolean isUnstatedPrice() {
        return isElementEnabled(Constants.BUSINESS_GIFT_INPUT);
    }

    public void pickGiftOption() {
        clickElement(Constants.BUSINESS_GIFT_BUTTON);
    }

    public void fillGiftAmount() {
        sendKeysToElement(Constants.BUSINESS_GIFT_INPUT, "1");
    }
}
