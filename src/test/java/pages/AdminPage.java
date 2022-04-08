package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.*;

public class AdminPage extends BasePage {

    // cac locator tim gia tri trong tables
    By trCusName2 = By.xpath("//*[@id=\"customer_tablebody\"]/tr[6]/td[3]");

    // cac locator cho tinh tong so cot va tong so hang
    // cac locator cho hien thi thong tin danh sach bang
    By ddbNumberList = By.xpath("//select[@name='CustomerList_length']");
    // cac locator cho chuc nang kim kiem
    By tfSearch = By.xpath("//input[@type='search']");
    // cac locator cho chuc nang xoa khach hang


    // tim mot gi tri trong hang
    public String findElementinTable() {

        // dieu huong sang trang customer CRUD
        driver.navigate().to("https://pos.anhtester.com/customer_list");

        boolean a = driver.findElement(trCusName2).isDisplayed();
        String b = driver.findElement(trCusName2).getText();
        ;
        if (a) {

            System.out.println(b);
            return b;
        } else return "Hong tim duoc cac";
    }

    // tinh tong hang va cot trong bang, van con loi xpath find element
    public int countTableRowsAndColunms() {
        // dieu huong den trang anh tester
        driver.navigate().to("https://pos.anhtester.com/customer_list");

        // tim tong so cot, xpath se tinh theo so th cua bang
        List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"CustomerList\"]/thead/tr/th"));
        System.out.println("So cot trong bang la " + col.size());
        // tim tong so hang, ham find elements nay tra vef cac locator co dai chi xpath giong nhau
        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr"));
        System.out.println("So hang cua bang la " + row.size());
        return col.size() + row.size();

    }

    // tinh lai tong hang va cot, tim gia tri ten phu hop
    public void totalfindCusByName() {
        // dieu huong den trang anh tester
        driver.navigate().to("https://pos.anhtester.com/customer_list");

        String name = "AnTest01";
        List<WebElement> row2 = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr/td[2]"));
        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr"));

        System.out.println(row2.size());
        System.out.println(row.size());

        for (int i = 0; i < row2.size(); i++) {
            if (name.equalsIgnoreCase(row2.get(i).getText())) {
                System.out.println(row.get(i).getText());
            }
        }

    }

    // nhap ten xuat ra thong tin khach hang theo cap key value ( su dung map ), cho nay can phai fix them
    public String inputNameOutputInfoKeyValue(String name) {
        driver.navigate().to("https://pos.anhtester.com/customer_list");
        List<Map<String, String>> TableData = new ArrayList<>();
        List<WebElement> HeaderData = driver.findElements(By.xpath("//*[@id=\"CustomerList\"]/thead/tr/th"));
        List<String> StoredHeader = new ArrayList<>();
        for (WebElement header : HeaderData) {
            String NameData = header.getText();
            StoredHeader.add(NameData);
        }
        List<WebElement> RowData = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr"));
        for (int i = 2; i < RowData.size(); i++) {
            List<WebElement> EachRowData = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr[" + i + "]/td"));
            Map<String, String> StoreEachRowData = new HashMap<>();
            for (int j = 0; j < EachRowData.size(); j++) {
                String CellData = EachRowData.get(j).getText();
                StoreEachRowData.put(StoredHeader.get(j), CellData);
            }
            TableData.add(StoreEachRowData);
        }
        for (Map<String, String> tableDatum : TableData) {
            List<String> list = new ArrayList<>(tableDatum.values());
            //System.out.println(list);
            for (String s : list) {
                if (s.contains(name)) {
                    System.out.println(s);
                    System.out.println(list);
                    System.out.println("Lam dep trai");
                    return "Tim duoc khach hang";
                }
            }
        }
        return "Khong tim duoc khach hang";
    }

        // lay la sai ngaay cho if
//        for (Map<String, String> tableDatum : TableData) {
//            if (Header.equalsIgnoreCase(tableDatum.keySet().toString())&& name.equalsIgnoreCase(tableDatum.values().toString())) {
//                System.out.println(tableDatum.values());
//                return "Tim duoc nguoi dung";
//
//            }
//            else return "Khong tim duoc nguoi dung";
//        }
//        return "Tim duoc nguoi dung";
//        System.out.println(TableData);
//        String Header = "Customer Name";
//        for (Map<String, String> tableDatum : TableData) {
//            if (Header.equalsIgnoreCase(tableDatum.keySet().toString())&& name.equalsIgnoreCase(tableDatum.values().toString())) {
//                System.out.println(tableDatum.values());
//                return "Tim duoc nguoi dung";
//
//            }
//            else return "Khong tim duoc nguoi dung";
//        }
//        return "Tim duoc nguoi dung";

  //  }
//        Map<String, String> NewMap = new HashMap<String, String>();
//        for (Map<String, String> DataCus : TableData){
//            for(Map.Entry<String,String> entry : DataCus.entrySet()){
//                NewMap.put(entry.getKey(), entry.getValue());
//            }
//        }
//        Set set = NewMap.keySet();
//       if(name.equalsIgnoreCase(String.valueOf(NewMap.containsValue("aaa"))))

//           for (Map.Entry<String, String> name1 : NewMap.entrySet()) {
//               if(name.equalsIgnoreCase(String.valueOf(NewMap.containsValue("aaa")))){
//                   System.out.println(name1.getValue());
//               }
//           }
////

//        for (String data: NewMap.values())
//        {
//            if (name.equalsIgnoreCase(data))
//            System.out.print(name);
//        }
//        return "Tim duoc khach hang";
//        System.out.println(NewMap);

//


    // nhap ten xuat ra thong tin khach hang
    public void inputNameOutputInfo(String name) {
        //dieu huong den trang anh tester
        driver.navigate().to("https://pos.anhtester.com/customer_list");

        List<WebElement> rowData = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr"));
        List<WebElement> rowHeader = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr/td[2]"));


        for (int i = 0; i < rowHeader.size(); i++) {
            if (name.equalsIgnoreCase(rowHeader.get(i).getText())) {
                System.out.println(rowData.get(i).getText());
            }
        }
    }

    // ham kiem tra hien thi cua bang
    public int selectNumberListofTable() {
        //dieu huong den trang anh tester
        driver.navigate().to("https://pos.anhtester.com/customer_list");
        // setup cac lua chon select
        Select numlist = new Select(driver.findElement(ddbNumberList));
        String a[] = {"10", "25", "50", "100", "250", "500", "All"};
        numlist.selectByVisibleText(a[1]);
        // setup kiem tra
        List<WebElement> numberTable = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr/td[1]"));
        int check = numberTable.size();
        if (check == 25) {
            return check;
        }
        return -1;
    }

    // ham tim kiem trong bang
    public String searchCusByName(String name) {
        //dieu huong den trang anh tester
        driver.navigate().to("https://pos.anhtester.com/customer_list");
        // nhap ten nguoi dung muon tim kiem
        driver.findElement(tfSearch).sendKeys(name);
        List<WebElement> row2 = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr/td[2]"));

        for (int i = 0; i < row2.size(); i++) {
            if (name.equalsIgnoreCase(row2.get(i).getText())){
                System.out.println(row2.get(i).getText());
            return "Tim kiem thanh cong";
            }
            else return  "Tim kiem khong thanh cong";
        }
        return "Nope";
    }

    //ham kiem tra chuc nang xoa trong bang
    public boolean deleteCustomer(){
        //dieu huong den trang anh tester
        driver.navigate().to("https://pos.anhtester.com/customer_list");
        // lay het cac nut xoa
        List<WebElement> btnDelete = driver.findElements(By.xpath("//*[@id=\"customer_tablebody\"]/tr/td[11]/a[2]"));
        // lay nut xoa dau tien
        boolean check = btnDelete.get(1).isDisplayed();
        btnDelete.get(1).click();
        if (!check){
            return true;
        } else
            return false;
    }
}
