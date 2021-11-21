package defaults;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {

    private static WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getInstance();
        driver.manage().window().maximize();
    }

    @Test
    public void stamTest() {
        driver.get("https://google.com/");
        System.out.println("- - - - -");
        System.out.println(driver.getTitle());
        System.out.println("- - - - -");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
