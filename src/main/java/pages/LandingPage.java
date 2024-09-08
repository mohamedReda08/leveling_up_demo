package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

     By searchBoxLocator = By.xpath("//div[@class = 'searchbox_searchbox__eaWKL']/input");

    public void navigate(){
        driver.navigate().to("https://duckduckgo.com/");
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public boolean logoIsDisplayed(){
        return driver.findElement(By.xpath("(//section//img)[2]")).isDisplayed();
    }
    public void search(String query){
        driver.findElement(searchBoxLocator).sendKeys(query, Keys.ENTER);

    }
}
