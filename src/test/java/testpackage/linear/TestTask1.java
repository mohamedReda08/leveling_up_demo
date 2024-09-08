package testpackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.SearchResultsPage;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TestTask1 {
    WebDriver driver;
    Wait<WebDriver> wait;
    LandingPage landingPage;
    SearchResultsPage searchResultsPage;
    String query;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        landingPage.navigate();

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(TimeoutException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .withMessage("Error occurred in wait function");

    }

    @Test
    public void testPageTitle(){
       String title = landingPage.getTitle();
        Assert.assertEquals(title, "DuckDuckGo — Privacy, simplified.");
    }

    @Test
    public void testLogo(){
      Assert.assertTrue(landingPage.logoIsDisplayed());
    }

    @Test
    public void testFirstResult(){
        query = "Selenium WebDriver";
        landingPage.search(query);

        wait.until(d->{
            String actualUrl = searchResultsPage.getSearchResultLink(1);
            String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";
            Assert.assertEquals(actualUrl,expectedUrl);
            return true;
        });
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
