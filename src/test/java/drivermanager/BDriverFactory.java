package drivermanager;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;


public class BDriverFactory {

        public static WebDriver InitDriver(String browser) {
            HashMap<String, BDriverManager> _driver;
            _driver = new HashMap<>();
            _driver.put("chrome", new ChromeDriverManager());
            _driver.put("edge", new EdgeDriverManager());
            BDriverManager bDriverManager =  _driver.get(browser);
            return  bDriverManager.getDriver();
        }
}
