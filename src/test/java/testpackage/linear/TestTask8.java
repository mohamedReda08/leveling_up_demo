package testpackage.linear;

import hookup.UploadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTask8 {
    WebDriver driver;
    UploadPage uploadPage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        uploadPage = new UploadPage(driver);
        uploadPage.navigate();
    }
    @AfterMethod
    public void tearDown(){uploadPage.tearDown();}

    @Test
    public void testUpload(){
        String expectedFileName = "image (6).png";
        String uploadedFileName = uploadPage.uploadFile();
        Assert.assertEquals(uploadedFileName, expectedFileName);
    }
}
