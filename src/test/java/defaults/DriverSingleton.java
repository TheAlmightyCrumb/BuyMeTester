package defaults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                ArrayList<String> keyNames = new ArrayList<>();
                keyNames.add("browserType");
                ArrayList<String> data = Utils.readFromXml("src/main/resources/config.xml", keyNames);
                BrowserTypes browserType = BrowserTypes.valueOf(data.get(0));
                switch (browserType) {
                    case Chrome:
                        System.setProperty("webdriver.chrome.driver", "/Users/batman/Downloads/chromedriver");
                        driver = new ChromeDriver();
                        break;
                    case Firefox:
                        System.setProperty("webdriver.gecko.driver", "/Users/batman/Downloads/geckodriver");
                        driver = new FirefoxDriver();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
