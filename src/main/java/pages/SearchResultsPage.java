package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    WebDriver driver;
    By searchResultLink;
    By fourthSearchResult = By.xpath("(//article)[4]//h2");
    By secondPageButton = By.xpath("//button[@id = 'more-results']");
    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSearchResultLink(int index) {
       return driver.findElement(searchLinkLocator(index)).getAttribute("href");
    }
    public String fourthSearchResult(){
        return driver.findElement(fourthSearchResult).getText();
    }
    public void moveToSecondPage(){
        driver.findElement(secondPageButton).click();
    }
    private By searchLinkLocator (int index){
        searchResultLink =  By.xpath("(//article//a)["+index+"]");
        return searchResultLink;
    }


}
