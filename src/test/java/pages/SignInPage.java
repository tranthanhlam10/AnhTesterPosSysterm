package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage{

    By inputUsername = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By btnLogin = By.xpath("//button[@class='btn btn-success']");


    public String Login(String user, String pass){

        driver.findElement(inputUsername).sendKeys(user);
        driver.findElement(inputPassword).sendKeys(pass);
        driver.findElement(btnLogin).click();

        return driver.getCurrentUrl();
    }
}
