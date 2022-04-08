package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

public class BaseTest {
    BasePage basePage = new BasePage();

    @BeforeClass
    public void setupTest(){
        basePage.setDriver();
        basePage.setupPropertiesFile();
    }
    @AfterClass
    public void tearDown(){
        basePage.tearDown();
    }
}
