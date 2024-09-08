package hookup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
    WebDriver driver;
    Actions actions;
    By dragLocator = By.xpath("//div[@id = 'draggable']");
    By dropLocator = By.xpath("//div[@id = 'droppable']");
    String url = "https://jqueryui.com/resources/demos/droppable/default.html";

    public DragDropPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.navigate().to(url);
    }

    public String getDroppedText(){
        return driver.findElement(dropLocator).getText();
    }

    public void dragAndDrop(){
        actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(dragLocator),
        driver.findElement(dropLocator)).build().perform();

    }
}
