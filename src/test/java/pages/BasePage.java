package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertiesFileReader;

import java.time.Duration;

public class BasePage {
      public static WebDriver driver;

      public void setDriver(){
          System.out.println("Launching Chrome browser...");
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.navigate().to("https://pos.anhtester.com/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // luon tim kiem 1 element trong khoang thoi gian 5s
          // Phuong thuc Wait nay la static setting, nen no se ap dung cho tat ca cac tuong hop su dung findelement
          // implicitlyWait dung cho toan bo cac lenh, con explicit wait chi duoc ap dung cho cac truong hop cu the
      }
      public void tearDown(){
          driver.quit();
      }

      public void setupPropertiesFile(){
          PropertiesFileReader.setPropertiesFile();
      }
}
