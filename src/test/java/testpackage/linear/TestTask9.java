package testpackage.linear;

import hookup.DragDropPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestTask9 {
    WebDriver driver;
    DragDropPage dragDropPage;

@BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        dragDropPage = new DragDropPage(driver);
        dragDropPage.navigate();
    }
@AfterMethod
    public void tearDown(){
        driver.quit();
    }
@Test
    public void testDragAndDrop(){
    String expectedText = "Dropped!";
    dragDropPage.dragAndDrop();
    Assert.assertEquals(dragDropPage.getDroppedText(),expectedText);
    }

}
