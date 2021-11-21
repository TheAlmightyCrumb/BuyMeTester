package defaults;

import org.openqa.selenium.By;

import java.util.HashMap;

public class Constants {
    /* Login & Register Form Locators */
    public static final By SWITCH_TO_REGISTER_BUTTON = By.cssSelector("div.register-or-login>span.text-link.theme");
    public static final By REGISTER_FIRST_NAME = By.cssSelector("form.ember-view[action=register] input[type=text]");
    public static final By REGISTER_EMAIL = By.cssSelector("form.ember-view[action=register] input[type=email]");
    public static final By REGISTER_PASSWORD = By.cssSelector("form.ember-view[action=register] input#valPass[type=password]");
    public static final By REGISTER_CONFIRM_PASS = By.cssSelector("form.ember-view[action=register] input[type=password]:not(#valPass)");

    /* Reigster Form Info */
    public static final String INPUT_FIRST_NAME = "Sagiv";
    public static final String INPUT_EMAIL = "sagivon18@gmail.com";
    public static final String INPUT_PASSWORD = "Mate1234";
    public static final String INPUT_CONFIRM_PASS = "Mate1234";
}
