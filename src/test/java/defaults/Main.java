package defaults;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Main {

    private static WebDriver driver;
    private static String baseUrl;
    private static final ExtentReports extent = new ExtentReports();
    private static final ExtentTest test = extent.createTest("Buyme Sanity Test", "Checking and reviewing basic user stories");
    private static final boolean userExists = true;

    @BeforeClass
    public static void init() {
        try {
            ArrayList<String> keyNames = new ArrayList<>();
            keyNames.add("baseUrl");
            ArrayList<String> data = Utils.readFromXml("src/main/resources/config.xml", keyNames);
            baseUrl = data.get(0);
        } catch(Exception e) {
            e.printStackTrace();
        }
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ExtentSparkReporter spark = new ExtentSparkReporter("./spark.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", "macOS 11.6");
        test.assignAuthor("TheAlmightyCrumb");
    }


    @Test(enabled = !userExists, priority = 1)
    public void registerTest() {
        ExtentTest registerTestNode = test.createNode("Register Test");
        RegisterPage registerPage = new RegisterPage(registerTestNode);
        String target = baseUrl + registerPage.getPageMatch();
        driver.get(target);
        registerTestNode.info("Browsing to: " + target);
        registerPage.clickSwitchForm();
        registerPage.fillRegisterForm();
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_FIRST_NAME), Constants.INPUT_FIRST_NAME);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_EMAIL), Constants.INPUT_EMAIL);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_PASSWORD), Constants.INPUT_PASSWORD);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_CONFIRM_PASS), Constants.INPUT_CONFIRM_PASS);
        registerTestNode.pass("Filled out register form successfully");
        try {
            registerPage.clickSignUp();
            registerTestNode.pass("Clicked sign-up button successfully");
        } catch(NullPointerException e) {
            e.printStackTrace();
            registerTestNode.fail("Failed to click sign-up button");
        }
    }

    @Test(enabled = userExists, priority = 1)
    public void loginTest() {
        ExtentTest loginTestNode = test.createNode("Login Test");
        RegisterPage loginPage = new RegisterPage(loginTestNode);
        String target = baseUrl + loginPage.getPageMatch();
        driver.get(target);
        loginTestNode.info("Browsing to: " + target);
        loginPage.fillLoginForm();
        try {
            loginPage.clickLogin();
            loginTestNode.pass("Clicked login button successfully");
        } catch(NullPointerException e) {
            e.printStackTrace();
            loginTestNode.fail("Failed to click login button");
        }
    }

    @Test(priority = 2)
    public void searchGiftTest() {
        ExtentTest searchGiftTestNode = test.createNode("Search Gift Test");
        HomePage homePage = new HomePage(searchGiftTestNode);
        String target = baseUrl;
        driver.get(target);
        searchGiftTestNode.info("Browsing to: " + target);
        homePage.pickOptionsFromSelects(false);
        searchGiftTestNode.pass("Picked random options from filters successfully");
        try {
            homePage.clickFindGift();
            searchGiftTestNode.pass("Clicked search button successfully");
        } catch(NullPointerException e) {
            e.printStackTrace();
            searchGiftTestNode.fail("Failed to click search button");
        }
    }

    @Test(dependsOnMethods = { "searchGiftTest" })
    public void resultsPageTest() {
        ExtentTest resultsPageTestNode = test.createNode("Results Page Test");
        ResultsPage resultsPage = new ResultsPage(resultsPageTestNode);
        ArrayList<String> selectedOptionsValues = resultsPage.getOptionsValuesFromSelects();
        try {
            HashMap<String, String> mappedValues = new HashMap<>();
            mappedValues.put("budget", selectedOptionsValues.get(0));
            mappedValues.put("region", selectedOptionsValues.get(1));
            mappedValues.put("category", selectedOptionsValues.get(2));
            for (String key: mappedValues.keySet()) {
                resultsPageTestNode.info(key + ": " + mappedValues.get(key));
            }
            String url = driver.getCurrentUrl();
            String expectedUrl = "https://buyme.co.il/search?budget=" + mappedValues.get("budget")
                    + "&category=" + mappedValues.get("category")
                    + "&region=" + mappedValues.get("region");
            Assert.assertEquals(url, expectedUrl);
            resultsPageTestNode.pass("Page url parameters sent correctly");
            resultsPage.clickBusinessCard();
            resultsPageTestNode.pass("Clicked business card successfully");
        } catch(AssertionError e) {
            e.printStackTrace();
            resultsPageTestNode.fail("Failed to get chosen parameters");
        } catch(NullPointerException e) {
            e.printStackTrace();
            resultsPageTestNode.fail("Failed to click on business card");
        }
        /* Moving to business page */
        ExtentTest businessPageTestNode = test.createNode("Business Page Test");
        BusinessPage businessPage = new BusinessPage(businessPageTestNode);
        try {
            businessPage.fillGiftAmount();
        } catch(NullPointerException e) {
            e.printStackTrace();
            businessPageTestNode.skip("Failed to pick price amount");
        } finally {
            businessPage.pickGiftOption();
            businessPageTestNode.pass("Picked price amount successfully");
        }
    }

    @Test(dependsOnMethods = { "resultsPageTest" })
    public void summaryPageTest() {
        ExtentTest summaryPageTestNode = test.createNode("Summary Page Test");
        SummaryPage summaryPage = new SummaryPage(summaryPageTestNode);
        try {
            summaryPage.clickSomeoneElse();
            summaryPageTestNode.pass("Clicked 'for someone else'");
            summaryPage.fillReceiverName();
            summaryPageTestNode.pass("Filled receiver's name");
            String receiverNameInputValue = summaryPage.getElementValue(Constants.RECEIVER_NAME_INPUT);
            summaryPage.pickEventFromSelect(false);
            summaryPageTestNode.pass("Selected option from events list");
            summaryPage.fillCustomBlessing();
            summaryPageTestNode.pass("Filled in a great blessing");
            summaryPage.addMedia();
            summaryPageTestNode.pass("Added media");
            summaryPage.clickContinue();
            summaryPageTestNode.pass("Continue to next stage");
            summaryPage.clickSendNow();
            summaryPageTestNode.pass("Clicked 'send now'");
            summaryPage.chooseSendByEmail();
            summaryPageTestNode.pass("Chosen email as sending method");
            summaryPage.fillReceiverEmail();
            summaryPageTestNode.pass("Filled receiver's email");
            summaryPage.fillSenderName();
            summaryPageTestNode.pass("Filled sender's name");
            String senderNameInputValue = summaryPage.getElementValue(Constants.SENDER_NAME_INPUT);
            summaryPage.clickContinue();
            summaryPageTestNode.pass("Continue to next stage");
            Assert.assertEquals(receiverNameInputValue, Constants.RECEIVER_NAME);
            Assert.assertEquals(senderNameInputValue, Constants.SENDER_NAME);
            summaryPageTestNode.pass("Filled sender and receiver details correctly");
        } catch(Exception e) {
            e.printStackTrace();
            summaryPageTestNode.fail("Something went wrong\n" + e.getMessage());
        }
    }

    @Test
    public void extraTest() {
        ExtentTest extraTestNode = test.createNode("Extras Test");
        RegisterPage registerPage = new RegisterPage(extraTestNode);
        driver.get(baseUrl + registerPage.getPageMatch());
        registerPage.clickLogin();
        String errorMessage = registerPage.getElementAttribute(Constants.LOGIN_EMAIL, "data-parsley-required-message");
        System.out.println(errorMessage);
        extraTestNode.info("Error message for no login credentials: " + errorMessage);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        extent.flush();
    }
}
