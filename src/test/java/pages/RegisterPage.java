package pages;

import defaults.Constants;

public class RegisterPage extends WebPage {

    public String getPageMatch() {
        return "?modal=login";
    }

    public void fillRegisterForm() {
        clickElement(Constants.SWITCH_TO_REGISTER_BUTTON);
        sendKeysToElement(Constants.REGISTER_FIRST_NAME, Constants.INPUT_FIRST_NAME);
        System.out.println("First name written.");
        System.out.println(getElementValue(Constants.REGISTER_FIRST_NAME));
        sendKeysToElement(Constants.REGISTER_EMAIL, Constants.INPUT_EMAIL);
        System.out.println("Email written.");
        System.out.println(getElementValue(Constants.REGISTER_EMAIL));
        sendKeysToElement(Constants.REGISTER_PASSWORD, Constants.INPUT_PASSWORD);
        System.out.println("Password written.");
        System.out.println(getElementValue(Constants.REGISTER_PASSWORD));
        sendKeysToElement(Constants.REGISTER_CONFIRM_PASS, Constants.INPUT_CONFIRM_PASS);
        System.out.println("Confirm pass written.");
        System.out.println(getElementValue(Constants.REGISTER_CONFIRM_PASS));
    }
}
