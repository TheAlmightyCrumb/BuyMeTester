package defaults;

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
        driver = DriverSingleton.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @Test
//    public void stamTest() {
//        driver.get(baseUrl);
//        System.out.println("- - - - -");
//        System.out.println(driver.getTitle());
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
    }
}
