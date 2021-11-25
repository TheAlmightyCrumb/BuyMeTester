package defaults;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;

public class Constants {

    private static final Dotenv dotenv = Dotenv.load();

    /* Login & Register Form Locators */

    public static final By SWITCH_FORM_LINK = By.cssSelector("div.register-or-login span.text-link.theme");

    // REGISTER FORM
    public static final By REGISTER_FIRST_NAME = By.cssSelector("form.ember-view[action=register] input[type=text]");
    public static final By REGISTER_EMAIL = By.cssSelector("form.ember-view[action=register] input[type=email]");
    public static final By REGISTER_PASSWORD = By.cssSelector("form.ember-view[action=register] input#valPass[type=password]");
    public static final By REGISTER_CONFIRM_PASS = By.cssSelector("form.ember-view[action=register] input[type=password]:not(#valPass)");
    public static final By REGISTER_BUTTON = By.cssSelector("form.ember-view[action=register] button[type=submit]");

    // LOGIN FORM
    public static final By LOGIN_EMAIL = By.cssSelector("form.entry.ember-view[action=recaptchaAuth] input[type=email]");
    public static final By LOGIN_PASSWORD = By.cssSelector("form.entry.ember-view[action=recaptchaAuth] input[type=password]");
    public static final By LOGIN_BUTTON = By.cssSelector("form.entry.ember-view[action=recaptchaAuth] button[type=submit]");


    // USER DETAILS
    public static final String INPUT_FIRST_NAME = "Sagiv";
    public static final String INPUT_EMAIL = "sagivon18@gmail.com";
    public static final String INPUT_PASSWORD = dotenv.get("BUYME_PASS");
    public static final String INPUT_CONFIRM_PASS = dotenv.get("BUYME_PASS");


    /* Homepage Locators */
    public static final By FILTERS_SELECTS = By.cssSelector("form.form.ember-view select");
    public static final String FILTERS_SELECTS_CSS_LOCATOR = "form.form.ember-view select";
    public static final By FIND_GIFT_BUTTON = By.cssSelector("form.form.ember-view a.ui-btn.search");
}
