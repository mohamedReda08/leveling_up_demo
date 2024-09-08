package hookup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/checkboxes";
    By firstCheckBoxLocator = By.xpath("(//input[@type = 'checkbox'])[1]");
    By secondCheckBoxLocator = By.xpath("(//input[@type = 'checkbox'])[2]");

    public CheckBox(WebDriver driver){
        this.driver = driver;
    }
    public void navigate(){
        driver.navigate().to(url);
    }
    public boolean selectFirstCheckBox(){
        WebElement firstCheckBox = driver.findElement(firstCheckBoxLocator);
        firstCheckBox.click();
        return firstCheckBox.isSelected();
    }
    public boolean secondCheckBox(){
        return driver.findElement(secondCheckBoxLocator).isSelected();
    }

}
