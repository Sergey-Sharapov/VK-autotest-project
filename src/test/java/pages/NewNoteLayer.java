package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewNoteLayer implements VisibleComponent{
    private final WebDriver driver;
    private final WebElement layer;

    private final By layerLoc = By.xpath("//div[@id='hook_Block_PopLayerMediaTopic']/div[@id='mtLayer']");
    private final By noteInputFieldLoc = By.xpath("//div[@id='hook_Block_PopLayerMediaTopic']/descendant::div[@class='posting_cnt']/descendant::div[@class='posting_itx-w']/div[2]");
    private final By postButtonLoc = By.xpath("//div[@class='posting_submit button-pro']");

    public NewNoteLayer(WebDriver driver){
        this.driver = driver;

        isVisible(driver, layerLoc);
        layer = driver.findElement(layerLoc);
    }

    public NewNoteLayer(WebDriver driver, WebElement layer){
        this.driver = driver;
        this.layer = layer;
    }

    public NewNoteLayer sendTextToNewNote(String text){
        isVisible(layer, noteInputFieldLoc);
        layer.findElement(noteInputFieldLoc).clear();
        layer.findElement(noteInputFieldLoc).sendKeys(text);
        return new NewNoteLayer(driver, layer);
    }

    public NewNoteLayer clickPostButton(){
        isVisible(layer, postButtonLoc);
        layer.findElement(postButtonLoc).click();
        return new NewNoteLayer(driver, layer);
    }
}
