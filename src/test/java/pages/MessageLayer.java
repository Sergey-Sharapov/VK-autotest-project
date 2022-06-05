package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessageLayer implements VisibleComponent{
    private final WebDriver driver;
    private final WebElement layer;

    private final By messageLayerLoc = By.id("msg_layer_wrapper");
    private final By messageInputFieldLoc = By.xpath("//div[@class='messenger_main']/descendant::msg-input");
    private final By sendButtonLoc = By.xpath("//div[@class='messenger_main']/descendant::msg-button[@data-l='t,sendButton']");

    MessageLayer(WebDriver driver){
        this.driver = driver;

        isVisible(driver, messageLayerLoc);
        layer = driver.findElement(messageLayerLoc);
    }

    MessageLayer(WebDriver driver, WebElement layer){
        this.driver = driver;
        this.layer = layer;
    }

    private By chatLoc(String title){
        return By.xpath("//msg-chats-list-item/a/div[@class='title']/msg-parsed-text[text()='"+title+"']");
    }

    public MessageLayer selectChat(String title){
        isVisible(layer, chatLoc(title));
        layer.findElement(chatLoc(title)).click();
        return new MessageLayer(driver, layer);
    }

    public MessageLayer inputTextMessage(String text){
        isVisible(layer, messageInputFieldLoc);
        layer.findElement(messageInputFieldLoc).clear();
        layer.findElement(messageInputFieldLoc).sendKeys(text);
        return new MessageLayer(driver, layer);
    }

    public MessageLayer sendMessage(){
        isVisible(layer, sendButtonLoc);
        layer.findElement(sendButtonLoc).click();
        return new MessageLayer(driver, layer);
    }

    private By messageLoc(int number){
        return By.xpath("//div[@class='messenger_main']/descendant::msg-message[last()+1-" + number + "]/div[@class='wrap']/div/div/div[@class='txt']/msg-parsed-text");
    }

    public String textOfMessageNumber(int number){
        isVisible(layer, messageLoc(number));
        return layer.findElement(messageLoc(number)).getText();
    }
}
