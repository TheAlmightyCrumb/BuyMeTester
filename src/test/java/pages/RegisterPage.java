package pages;

import com.aventstack.extentreports.ExtentTest;
import defaults.Constants;

public class RegisterPage extends WebPage {

    public RegisterPage(ExtentTest test) {
        super(test);
    }

    public String getPageMatch() {
        return "?modal=login";
    }

    public void clickSwitchForm() {
        clickElement(Constants.SWITCH_FORM_LINK);
    }

    public void fillRegisterForm() {
        sendKeysToElement(Constants.REGISTER_FIRST_NAME, Constants.INPUT_FIRST_NAME);
        sendKeysToElement(Constants.REGISTER_EMAIL, Constants.INPUT_EMAIL);
        sendKeysToElement(Constants.REGISTER_PASSWORD, Constants.INPUT_PASSWORD);
        sendKeysToElement(Constants.REGISTER_CONFIRM_PASS, Constants.INPUT_CONFIRM_PASS);
    }

    public void clickSignUp() {
        clickElement(Constants.REGISTER_BUTTON);
    }

    public void fillLoginForm() {
        sendKeysToElement(Constants.LOGIN_EMAIL, Constants.INPUT_EMAIL);
        sendKeysToElement(Constants.LOGIN_PASSWORD, Constants.INPUT_PASSWORD);
    }

    public void clickLogin() {
        clickElement(Constants.LOGIN_BUTTON);
    }
}
