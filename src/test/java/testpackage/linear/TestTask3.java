package testpackage.linear;

import hookup.CheckBox;
import hookup.TablesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTask3 {
WebDriver driver;
CheckBox checkBox;
TablesPage tablesPage;
@BeforeMethod
    public void setup(){
    driver = new ChromeDriver();
    checkBox = new CheckBox(driver);
    checkBox.navigate();
    tablesPage = new TablesPage(driver);
    tablesPage.navigate();
}

@AfterMethod
    public void quit(){ driver.quit();}

@Test
    public void testCheckBox(){
    Assert.assertTrue(checkBox.selectFirstCheckBox()
                                && checkBox.secondCheckBox());
    }

@Test
    public void testTable(){
        String expectedCountry = "Austria";
        String actualCountry = tablesPage.tableCell();
        Assert.assertEquals(actualCountry,expectedCountry);
    }
}
