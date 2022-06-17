package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends  BDriverManager{

    @Override
    public WebDriver getDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
