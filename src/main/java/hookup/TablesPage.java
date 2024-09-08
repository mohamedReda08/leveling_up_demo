package hookup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablesPage {
    //Variables
    WebDriver driver;
    String url = "https://www.w3schools.com/html/html_tables.asp";
    //Constructor

    public TablesPage(WebDriver driver){
        this.driver = driver;
    }
    // Locators
    By cellLocator = By.xpath("(//td[text() = 'Ernst Handel']/following-sibling::td)[2]");
    //public Methods
    public void navigate(){
        driver.navigate().to(url);
    }
    public String tableCell(){
        return driver.findElement(cellLocator).getText();
    }
    //private methods
}
