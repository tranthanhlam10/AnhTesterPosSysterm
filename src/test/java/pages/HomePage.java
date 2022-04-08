package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomePage extends BasePage {


    //tao action class

    //cac locator for search
    By inputSearchBar = By.xpath("//input[@id='product_name']");
    By itemTiger = By.xpath("//div[@id='image-active_123456']//img[@class='img-responsive']");

    //cac locator trong form them khach hang muc order
    By btnAdd = By.xpath("//button[@id='customermodal-link']");
    By formAdd = By.xpath("//form[@id='newcustomer']//div[@class='panel-body']"); // form them khach hang
    By inputCusName = By.xpath("//input[@id='m_customer_name']");
    By inputCusEmail = By.xpath("//input[@id='email']");
    By inputCusPhone = By.xpath("//input[@id='mobile']");
    By txtareaCusAddress = By.xpath("//textarea[@id='address ']");
    By btnSubmit = By.xpath("//input[@value='Submit']");
    By popupMessage = By.xpath("//div[@class='toast-message']"); // thong bao khi them khac hang thanh cong

    //cac locator them khach hang trong trang quan ly
    By inputdbCusEmail = By.xpath("//div[@class='col-sm-4']//div//input[@id='email']");
    By inputdbCusPhone = By.xpath("//input[@id='phone']");
    By textareadbCusAddress = By.xpath("//textarea[@id='customer_address']");
    By inputdbCusFax = By.xpath("//input[@id='fax']");
    By inputdbCusState = By.xpath("//input[@id='state']");
    By inputdbCusCountry = By.xpath("//input[@id='country']");
    By inputdbCusMobiNo = By.xpath("//input[@id='customer_mobile']");
    By inputdbCusEmailAddress2 = By.xpath("//input[@id='email_address']");
    By inputdbCusContact = By.xpath("//input[@id='contact']");
    By textareadbCusAddress2 = By.xpath("//textarea[@id='address2']");
    By inputdbCusCity = By.xpath("//input[@id='city']");
    By inputdbCusZipCode = By.xpath("//input[@id='zip']");
    By inputdbCusPreBalance = By.xpath("//form[@id='customer_form']");
    By btndbCusSave = By.xpath("//button[@type='button']");
    By messageSuccess = By.xpath("//div[@class='toast-message']");

    //cac locator dashboard homepage
    By ddbCustommer = By.xpath("//body/div[@class='wrapper']/aside[@class='main-sidebar']/div[@class='sidebar']/ul[@class='sidebar-menu']/li[@class='treeview active']/a[1]");
    By ddbCustommer2 = By.xpath("//i[@class='metismenu-icon pe-7s-user']");
    //cac locator cho chuc nang mua hang
    By itemExtra = By.xpath("//div[@id='product_search']//div[1]//div[1]//div[1]//img[1]");
    By btnSaveSale = By.xpath("//input[@id='add_invoice']");
    By popupSale1 = By.xpath("//div[@class='sweet-alert showSweetAlert visible']");
    By popupSale = By.xpath("//h2[normalize-space()='Success!']");
    By btnCancel =  By.xpath("//button[@class='cancel']");

    // cac locator cho chuc nang Customer Advice
    By dropdownCusName = By.xpath("//span[@id='select2-customer_id-xo-container']");
    By dropdownCusType = By.xpath("//span[@id='select2-type-fs-container']");
    By inputAmount = By.xpath("//input[@id='amount']");
    By btnCusAdviceSave = By.xpath("//input[@id='add-customer-advance']");



    //tim kiem san pham
    public Boolean searchItems(String item){
        driver.findElement(inputSearchBar).sendKeys(item);
        return driver.findElement(itemTiger).isDisplayed();
    }

    //them khach hang moi, cho nay van con sai, co gi fix sau
    public void addNewCustomer(String name, String email, String phone, String address){

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(btnAdd)).build().perform();
        if (driver.findElement(formAdd).isDisplayed()){
        //dien thong tin khach hang
        driver.findElement(inputCusName).sendKeys(name);
        driver.findElement(inputCusEmail).sendKeys(email);
        driver.findElement(inputCusPhone).sendKeys(phone);
        driver.findElement(txtareaCusAddress).sendKeys(address);
        // submit form
        driver.findElement(btnSubmit).click();
        }
        else System.out.println("Test case thuc hien khong thanh cong ");
    }


     // them khach hang tren trang dashboard
    public void addNewCustomerInDashBoard(String name, String email, String phone, String address, String fax, String state, String country, String mobino, String address2, String contact, String email2, String city, String zip, String preba){

          driver.navigate().to("https://pos.anhtester.com/add_customer");

            if (driver.getCurrentUrl().equalsIgnoreCase("https://pos.anhtester.com/add_customer")) {

//                driver.findElement(inputdbCusName).sendKeys(name);
                driver.findElement(inputdbCusEmail).sendKeys(email);
                driver.findElement(inputdbCusPhone).sendKeys(phone);
                driver.findElement(textareadbCusAddress).sendKeys(address);
                driver.findElement(inputdbCusFax).sendKeys(fax);
                driver.findElement(inputdbCusState).sendKeys(state);
                driver.findElement(inputdbCusCountry).sendKeys(country);
                driver.findElement(inputdbCusMobiNo).sendKeys(mobino);
                driver.findElement(textareadbCusAddress2).sendKeys(address2);
                driver.findElement(inputdbCusContact).sendKeys(contact);
                driver.findElement(inputdbCusEmailAddress2).sendKeys(email2);
                driver.findElement(inputdbCusCity).sendKeys(city);
                driver.findElement(inputdbCusZipCode).sendKeys(zip);

            // xac nhan them thanh cong
            driver.findElement(btndbCusSave).click();

            if (driver.findElement(messageSuccess).isDisplayed()) {
                System.out.println("Them khach hang thanh cong");
            }
            else {
                System.out.println("Them khach hang khong thanh cong");
            }
        } else {
                System.out.println("Test case thuc hien khong thanh cong");
            }

    }

    // kiem tra chon cac muc trong customer, tai sao van bi sai nhi ?
    public void clickLeftBarCustomer(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ddbCustommer2)));
    }

    // kiem tra chuc nang dat hang, con chua xu li duoc cai popup
    public String buySomeItems() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='product_search']//div[1]//div[1]//div[1]//img[1]"))); // cho time out 5s de doi vat pham click dc
        driver.findElement(itemExtra).click();

        // sau khi click xong la doi 1 xiu de cai popup hien len
        driver.findElement(btnSaveSale).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(popupSale1)));
        if (driver.findElement(popupSale1).isDisplayed()) {

            driver.findElement(btnCancel).click();
            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                System.out.println(" Test case khong thanh cong");
                return "Mua hang khong thanh cong";
            } else {
                System.out.println("Mua hang thanh cong");
            }
        }
        return "Mua hang thanh cong";
    }

    // kiem tra chuc nang customer advices, van con loi cho xpath khong dung ?
    public String createCustomerAdvice(){
        driver.navigate().to("https://pos.anhtester.com/customer_advance");
        if (driver.getCurrentUrl().equalsIgnoreCase("https://pos.anhtester.com/customer_advance")) {

            // can phai xem lai cho nay, dropdown button nay can phai xac dinh lai dung
            Select select = new Select(driver.findElement(By.id("select2-customer_id-xo-container")));
            select.selectByVisibleText("Thông soái ca"); // chon truong cho dropdown

            Select select1 = new Select(driver.findElement(By.id("select2-type-fs-container")));
            select1.selectByVisibleText("Payment"); // chon truong cho dropodown

            driver.findElement(inputAmount).sendKeys("10");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(inputAmount), "10"));

            driver.findElement(btnCusAdviceSave).click();

            return "Them hoa don thanh cong";
        } else

            return "Khong thanh cong";
    }




}
