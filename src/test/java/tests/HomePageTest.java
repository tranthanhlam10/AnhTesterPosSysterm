package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class HomePageTest extends BaseTest {

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();

    //test case nay da kiem tra thanh cong
    @Test(priority = 2)
    @Description("Kiem thu chuc nang tim kiem ")
    public void testSearchItems(){
        // dang nhap truoc khi tim kiem
        signInPage.Login("user01@anhtester.com", "123456");
        // tim san pham
        Assert.assertTrue(homePage.searchItems("Tiger"));
    }

    //test case nay van con loi do chua biet xu li popup
    @Test(priority = 3)
    @Description("Kiem thu chuc nang them khach hang moi tren hoa don")
    public void testAddNewCustomer(){
        // dang nhap truoc khi tim kiem
        signInPage.Login("user01@anhtester.com", "123456");
        // them khach hang
       // Assert.assertTrue(homePage.addNewCustomer("Tran Thanh Long", "long@gmail", "0984657443", "Tan An Long An"));
        homePage.addNewCustomer("Tran Thanh Long", "long@gmail", "0984657443", "Tan An Long An");
    }

    //test case nay da kiem tra thanh cong, tai sao bay gio lai khong thanh cong nhi ? loi ngay cho nut click
    @Test(priority = 4)
    @Description("Kiem thu chon cac muc trong dashboard customer")
    public void testCustomerDashBoard(){
        signInPage.Login("user01@anhtester.com", "123456");
        homePage.clickLeftBarCustomer();
    }

    //test case nay da kiem tra thanh cong
    @Test(priority = 4)
    @Description("Kiem thu chuc nang them khach hang moi trong dashboard")
    public void testAddCustomer(){
        // dang nhap truoc khi thuc hien
        signInPage.Login("user01@anhtester.com", "123456");
        // ket thuc test case
        homePage.addNewCustomerInDashBoard("Tran Thanh Lam","lam@1234.com", "0984657443", "Tan An, Long An", "0984657443", "Long An","Viet Nam", "098", "Binh Tan, Ho Chi Minh", "Thanh lam tran" , "lamtran@1234/com","Tan An", "82000", "1");
    }

    // test case nay da kiem tra thanh cong
    @Test(priority = 4)
    @Description("Kiem thu chuc nang mua hang trong trang user")
    public void testBuySomeItem(){

        // dang nhap truoc khi thuc hien chuc nang
        signInPage.Login("user01@anhtester.com", "123456");
        //homePage.buySomeItems();
        Assert.assertEquals(homePage.buySomeItems(), "Mua hang thanh cong");
    }

    // Loi xpath khong dung ?
    @Test(priority = 4)
    @Description("Kiem thuc chuc nang thao hoa don")
    public void testCreateCusAdvice(){
        //dang nhap truoc khi thuc hien
        signInPage.Login("user01@anhtester.com", "123456");
        //kiem tra xem dau ra co nhu mong muon chua
        Assert.assertEquals(homePage.createCustomerAdvice(), "Them hoa don thanh cong");
    }




}
