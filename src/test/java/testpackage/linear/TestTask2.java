package testpackage.linear;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.SearchResultsPage;

import java.time.Duration;

public class TestTask2 {
    WebDriver driver;
    Wait<WebDriver> wait;
    LandingPage landingPage;
    SearchResultsPage searchResultsPage;
    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        landingPage = new LandingPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        landingPage.navigate();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofNanos(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testTask4(){
        String expectedText = "TestNG Tutorial";
        String query = "TestNG";
        landingPage.search(query);
        wait.until(d->{
            String actualSearchText =  searchResultsPage.fourthSearchResult();
            Assert.assertEquals(actualSearchText, expectedText);
            return true;
        });
    }

    @Test
    public void testTask5(){
        String query = "Cucumber IO";
        landingPage.search(query);

        wait.until(d->{
            String expectedLink = "https://www.linkedin.com";
            searchResultsPage.moveToSecondPage();
            String actualLink = searchResultsPage.getSearchResultLink(11);
            System.out.println("Actual Link is "+actualLink);
            Assert.assertTrue(actualLink.contains(expectedLink));
            return true;
        });


    }


}
