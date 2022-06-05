package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessageLayer implements LoadableComponent{
    private final WebDriver driver;
    private final WebElement layer;
    private final By messageLayerLoc = By.id("msg_layer_wrapper");
    private final By messageInputFieldLoc = By.xpath("//div[@class='messenger_main']/descendant::msg-input");
    private final By sendButtonLoc = By.xpath("//div[@class='messenger_main']/descendant::msg-button[@data-l='t,sendButton']");

    MessageLayer(WebDriver driver){
        this.driver = driver;
        isComponentLoaded(driver, messageLayerLoc);
        layer = driver.findElement(messageLayerLoc);
    }

    private By chatLoc(String title){
        return By.xpath("//msg-chats-list-item/a/div[@class='title']/msg-parsed-text[text()='"+title+"']");
    }

    public MessageLayer selectChat(String title){
        isComponentLoaded(driver, chatLoc(title));
        driver.findElement(chatLoc(title)).click();
        return new MessageLayer(driver);
    }

    public MessageLayer inputTextMessage(String text){
        isComponentLoaded(driver, messageInputFieldLoc);
        driver.findElement(messageInputFieldLoc).sendKeys(text);
        return new MessageLayer(driver);
    }

    public MessageLayer sendMessage(){
        isComponentLoaded(driver, sendButtonLoc);
        driver.findElement(sendButtonLoc).click();
        return new MessageLayer(driver);
    }

    private By messageLoc(int number){
        return By.xpath("//div[@class='messenger_main']/descendant::msg-message[last()+1-" + number + "]/div[@class='wrap']/div/div/div[@class='txt']/msg-parsed-text");
    }

    public String textOfMessageNumber(int number){
        isComponentLoaded(driver, messageLoc(number));
        return driver.findElement(messageLoc(number)).getText();
    }
}
