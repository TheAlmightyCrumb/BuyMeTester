package pages;

import com.aventstack.extentreports.ExtentTest;
import defaults.Constants;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SummaryPage extends WebPage {

    private final Random rand = new Random();

    public SummaryPage(ExtentTest test) {
        super(test);
    }

    public void clickSomeoneElse() {
        clickElement(Constants.FOR_SOMEONE_ELSE_BUTTON);
    }

    public void fillReceiverName() {
        sendKeysToElement(Constants.RECEIVER_NAME_INPUT, Constants.RECEIVER_NAME);
    }

    public void pickEventFromSelect(boolean random) {
        clickElement(Constants.EVENT_SELECT_WRAPPER);
        List<WebElement> eventOptions = findWebElements(Constants.EVENT_SELECT_OPTIONS);
        int randomIndex = rand.nextInt(eventOptions.size() - 1) + 1;
        WebElement chosenOption;
        chosenOption = eventOptions.get(2);
        if (random)
            chosenOption = eventOptions.get(randomIndex);
        executeJavaScript("arguments[0].scrollIntoView();", chosenOption);
        chosenOption.click();
    }

    public void fillCustomBlessing() {
        clearKeysFromElement(Constants.BLESSING_TEXTAREA);
        sendKeysToElement(Constants.BLESSING_TEXTAREA, Constants.BLESSING);
    }

    public void addMedia() {
        sendKeysToElement(Constants.ADD_MEDIA_INPUT, Constants.ADD_MEDIA_PATH);
    }

    public void clickContinue() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        clickElement(Constants.CONTINUE_BUTTON);
    }

    public void clickSendNow() {
        clickElement(Constants.SEND_NOW_BUTTON);
    }

    public void chooseSendByEmail() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        clickElement(Constants.EMAIL_SVG);
    }

    public void fillReceiverEmail() {
        sendKeysToElement(Constants.RECEIVER_EMAIL_INPUT, Constants.RECEIVER_EMAIL);
    }

    public void fillSenderName() {
        sendKeysToElement(Constants.SENDER_NAME_INPUT, Constants.SENDER_NAME);
    }
}
