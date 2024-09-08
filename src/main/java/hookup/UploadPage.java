package hookup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UploadPage {
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/upload";
        By uploadButtonLocator = By.xpath("//input[@id = 'file-upload']");
        By submitButtonLocator = By.xpath("//input[@id = 'file-submit']");
        By uploadedFileLocator = By.xpath("//div[@id = 'uploaded-files']");
        File uploadFile = new File("C:/Users/user/Downloads/image (6).png");

    public UploadPage(WebDriver driver){
        this.driver = driver;
    }
    public void navigate(){
        driver.navigate().to(url);
    }
    public void tearDown(){
        driver.quit();
    }
    public String uploadFile(){
        driver.findElement(uploadButtonLocator).sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(submitButtonLocator).click();
        return driver.findElement(uploadedFileLocator).getText();
    }

}
