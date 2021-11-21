import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getInstance(BrowserTypes browserType) {
        if (driver == null) {
            switch (browserType) {
                case Chrome:
                    System.setProperty("webdriver.chrome.driver", "/Users/batman/Downloads/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case Firefox:
                    System.setProperty("webdriver.gecko.driver", "/Users/batman/Downloads/geckodriver");
                    driver = new FirefoxDriver();

            }

        }
        return driver;
    }
}
