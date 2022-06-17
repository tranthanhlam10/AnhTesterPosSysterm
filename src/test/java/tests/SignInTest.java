package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignInPage;
import utils.PropertiesFileReader;

public class SignInTest extends BaseTest{


    // Test case nay da kiem tra thanh cong, da bo du lieu vo file properties
    @Test(priority = 1)
    @Description("Kiem tra dang nhap trang anh tester pos, du lieu duoc nhap tu file properties")
    public void testLogin(){
        Assert.assertEquals(SignInPage.getInstance().Login(PropertiesFileReader.getPropValue("user"), PropertiesFileReader.getPropValue("pass")), "https://pos.anhtester.com/gui_pos");
    }

    @DataProvider(name = "Login-Test")
    public Object[][] dpMethod(){
        return new Object[][]{{"user03@anhtester.com", "123456"}, {"user04@anhtester.com", "123456"}, {"thongsoaica", "12345"}};
    }

    // Test case nay da kiem tra thanh cong
    @Test(priority = 1, dataProvider = "Login-Test")
    @Description("Kiem tra dang nhap voi nhieu tai khoan khac")
    public void testLoginWithDifferentAccount(String user, String pass){
        Assert.assertEquals(SignInPage.getInstance().Login(user, pass), "https://pos.anhtester.com/gui_pos/");
    }
}
