package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage{

    private static SignInPage _instance;

    private  SignInPage(){}

    public static SignInPage getInstance(){
        if(_instance == null)
            _instance = new SignInPage();
        return _instance;
    }

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
