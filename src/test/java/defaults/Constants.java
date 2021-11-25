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
    public static final String INPUT_EMAIL = dotenv.get("BUYME_EMAIL");
    public static final String INPUT_PASSWORD = dotenv.get("BUYME_PASS");
    public static final String INPUT_CONFIRM_PASS = dotenv.get("BUYME_PASS");

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /* Homepage Locators */

    public static final By FILTERS_SELECTS = By.cssSelector("form.form.ember-view select");
    public static final String FILTERS_SELECTS_CSS_LOCATOR = "form.form.ember-view select";
    public static final By FIND_GIFT_BUTTON = By.cssSelector("form.form.ember-view a.ui-btn.search");

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /* Results and Business Locators */

    public static final By BUSINESS_CARD = By.cssSelector("div.application-main div.ember-view.bm-product-card");
    public static final By BUSINESS_GIFT_INPUT = By.cssSelector("div.ember-view.bm-gift-card input.ember-text-field");
    public static final By BUSINESS_GIFT_BUTTON = By.cssSelector("div.ember-view.bm-gift-card button.ember-view.bm-btn");

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /* Summary Page Locators */

    // STAGE 1
    public static final By FOR_SOMEONE_ELSE_BUTTON = By.cssSelector("div.button-forSomeone");
    public static final By RECEIVER_NAME_INPUT = By.cssSelector("label#friendName input.ember-text-field");
    public static final By EVENT_SELECT_WRAPPER = By.cssSelector("div.selected-name");
    public static final By EVENT_SELECT_OPTIONS = By.cssSelector("div.dropdown li");
    public static final By BLESSING_TEXTAREA = By.cssSelector("label.bm-textarea textarea");
    public static final By ADD_MEDIA_INPUT = By.cssSelector("label.media-circle-btn input[type=file]");
    public static final By CONTINUE_BUTTON = By.cssSelector("button.main.bm-btn");

    // STAGE 2
    public static final By SEND_NOW_BUTTON = By.cssSelector("div.button-now");
    public static final By EMAIL_SVG = By.cssSelector("svg[gtm=method-email] path.circle");
    public static final By RECEIVER_EMAIL_INPUT = By.cssSelector("input#email[type=email]");
    public static final By SENDER_NAME_INPUT = By.cssSelector("label.with-label input.ember-text-field");

    // SUMMARY DETAILS
    public static final String RECEIVER_NAME = "Moshik";
    public static final String BLESSING = "Hello Mate, Congrats! :D";
    public static final String ADD_MEDIA_PATH = "/Users/batman/IntelliJProjects/BuyMeTester/MediaToAdd.png";
    public static final String RECEIVER_EMAIL = "Moshik@mafia.mate";
    public static final String SENDER_NAME = "George";

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    /* Loading Screen */

    public static final By LOADING_SPINNER_DOT = By.cssSelector("div.spinner div.bounce1");
}
