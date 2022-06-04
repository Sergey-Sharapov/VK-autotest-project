package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessageLayer implements LoadableComponent{
    private final WebDriver driver;
    private final WebElement layer;
    private final By messageLayerLoc = By.id("msg_layer_wrapper");

    MessageLayer(WebDriver driver){
        this.driver = driver;
        isComponentLoaded(driver, messageLayerLoc);
        layer = driver.findElement(messageLayerLoc);
    }

    private By chatLoc(String title){
        return By.xpath("//msg-chats-list-item/a/div[@class='title' && text()='" + title+ "']/.");
    }

    //public MessageLayer selectChat(String title){

   // }

}
