package defaults;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

    private static WebDriver driver;
    private static String baseUrl;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

    @BeforeClass
    public void init() {
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
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("src/extent.html");
        extent.attachReporter(htmlReporter);
    }

//    @Test
//    public void stamTest() {
//        driver.get(baseUrl);
//        System.out.println("- - - - -");
//        try {
//            System.out.println(driver.findElement(By.id("Mate")));
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//            System.out.println("NO SUCH ELEMENT EXCEPTION WAS THROWN");
//        }
//        System.out.println("- - - - -");
//    }

    @Test
    public void registerTest() {
        RegisterPage registerPage = new RegisterPage();
        driver.get(baseUrl + registerPage.getPageMatch());
        registerPage.fillRegisterForm();
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_FIRST_NAME), Constants.INPUT_FIRST_NAME);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_EMAIL), Constants.INPUT_EMAIL);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_PASSWORD), Constants.INPUT_PASSWORD);
        Assert.assertEquals(registerPage.getElementValue(Constants.REGISTER_CONFIRM_PASS), Constants.INPUT_CONFIRM_PASS);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        extent.flush();
    }
}
