package defaults;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

    private static WebDriver driver;
    private static String baseUrl;
    private static final ExtentReports extent = new ExtentReports();
    private static final ExtentTest test = extent.createTest("Buyme Sanity Test", "Checking and reviewing basic user stories");

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
    }


    @Test(enabled = false)
    public void registerTest() {
        ExtentTest registerTestNode = test.createNode("Register Test");
        RegisterPage registerPage = new RegisterPage(registerTestNode);
        String target = baseUrl + registerPage.getPageMatch();
        driver.get(target);
        registerTestNode.info("Browsing to: " + target + ".");
        registerPage.fillRegisterForm();
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_FIRST_NAME), Constants.INPUT_FIRST_NAME);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_EMAIL), Constants.INPUT_EMAIL);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_PASSWORD), Constants.INPUT_PASSWORD);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_CONFIRM_PASS), Constants.INPUT_CONFIRM_PASS);
        registerTestNode.pass("Filled out register form successfully.");
        try {
            registerPage.clickSignUp();
            registerTestNode.pass("Clicked sign-up button successfully.");
        } catch(NullPointerException e) {
            e.printStackTrace();
            registerTestNode.fail("Failed to click sign-up button.");
        }
    }

    @Test
    public void searchGiftTest() {
        ExtentTest searchGiftTestNode = test.createNode("Search Gift Test");
        HomePage homePage = new HomePage(searchGiftTestNode);
        String target = baseUrl + homePage.getPageMatch();
        driver.get(target);
        searchGiftTestNode.info("Browsing to: " + target + ".");
        homePage.pickOptionsFromSelects();
        searchGiftTestNode.pass("Picked random options from filters successfully.");
        try {
            homePage.clickFindGift();
            searchGiftTestNode.pass("Clicked search button successfully.");
        } catch(NullPointerException e) {
            e.printStackTrace();
            searchGiftTestNode.fail("Failed to click search button.");
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        extent.flush();
    }
}
