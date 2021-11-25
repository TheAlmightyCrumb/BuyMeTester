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
//        System.out.println("First name written.");
//        System.out.println(getElementValue(Constants.REGISTER_FIRST_NAME));
        sendKeysToElement(Constants.REGISTER_EMAIL, Constants.INPUT_EMAIL);
//        System.out.println("Email written.");
//        System.out.println(getElementValue(Constants.REGISTER_EMAIL));
        sendKeysToElement(Constants.REGISTER_PASSWORD, Constants.INPUT_PASSWORD);
//        System.out.println("Password written.");
//        System.out.println("*".repeat(getElementValue(Constants.REGISTER_PASSWORD).length()));
        sendKeysToElement(Constants.REGISTER_CONFIRM_PASS, Constants.INPUT_CONFIRM_PASS);
//        System.out.println("Confirm pass written.");
//        System.out.println("*".repeat(getElementValue(Constants.REGISTER_CONFIRM_PASS).length()));
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
