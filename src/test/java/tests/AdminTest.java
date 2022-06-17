package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.SignInPage;

public class AdminTest extends BaseTest {


    @BeforeMethod
    public void signIn(){
        SignInPage.getInstance().Login("user01@anhtester.com", "123456");
    }

    // test case kiem tra thanh cong
    @Test(priority = 1)
    @Description("Tim mot gia tri trong bang")
    public void getTextOnTable() {
        String a = AdminPage.getInstance().findElementinTable();
        Assert.assertEquals(a, "Address1");
    }

    // test case nay kiem tra thanh cong
    @Test(priority = 1)
    @Description("Tinh tong cot va tong hang trong ban")
    public void countColAndRowOnTable() {
        Assert.assertEquals(AdminPage.getInstance().countTableRowsAndColunms(), 21); // tong so cot va so hang trong 1 trang table
    }

    //tesst case kiem tra thanh cong
    @Test(priority = 1)
    @Description("Tao nho Ho Nhi qua")
    public void totalsColsAndRows() {
        AdminPage.getInstance().totalfindCusByName();
    }

    // cho nay sao no khong xuat ra cai gi nhi
    @Test(priority = 1)
    @Description("Kiem tra nhap ten khach hang xuat ra thong tin")
    public void inputNameOutputInfo() {
        AdminPage.getInstance().inputNameOutputInfo("Cust_Test001");

    }

    // test case nay da kiem tra thanh cong
    @Test(priority = 2)
    @Description("Kiem tra xem hien thi table khi nhap drop down co dung hay khong")
    public void checkNumberOfTable(){
        Assert.assertEquals(AdminPage.getInstance().selectNumberListofTable(), 26);
    }

    // test case nay da kiem tra thanh cong
    @Test(priority = 3)
    @Description("Kiem tra chuc nang search trong bang")
    public void searchCusName(){
        Assert.assertEquals(AdminPage.getInstance().searchCusByName("Trần Thanh Lâm"),"Tim kiem thanh cong");
    }

    // test case nay da kiem tra thanh cong
    @Test(priority = 4)
    @Description("Kiem thu chuc nang xoa trong bang")
    public void deleteCustomer(){
        Assert.assertFalse(AdminPage.getInstance().deleteCustomer());
    }

    @Test(priority = 2)
    @Description("Kiem thu tim kiem nhan vien bang map")
    public void inputNameOutputInfoMap(){
        Assert.assertEquals(AdminPage.getInstance().inputNameOutputInfoKeyValue("09875324578"),"Tim duoc khach hang","Nguoi dung co ton tai");

    }


}
