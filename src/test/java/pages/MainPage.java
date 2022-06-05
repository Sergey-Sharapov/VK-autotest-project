package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.User;

public class MainPage implements VisibleComponent {
    private final WebDriver driver;

    private final By fullnameLoc = By.xpath("//div[@class='nav-side __navigation __user-main']/div[1]/a/div");
    private final By noteFieldLoc = By.xpath("//div[@id='hook_Block_PostingForm']/descendant::div[@class='pf-head_itx']/a");
    private final By toolbarMessageLoc = By.xpath("//ul[@class='toolbar_nav']/li[@data-l='t,messages']/div[1]");
    //private final By messageLayerLoc = By.id("msg_layer_wrapper");
    //private final By byPostButtonXpath = By.xpath("//div[@class='feed-list __compact']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isUserNameCorrect(User user){
        isVisible(driver, fullnameLoc);
        return driver.findElement(fullnameLoc).getText().equals(user.getFullName());
    }

    public NewNoteLayer openNewNoteLayer() {
        isVisible(driver, noteFieldLoc);
        driver.findElement(noteFieldLoc).click();
        return new NewNoteLayer(driver);
    }

    public MessageLayer openMessageLayer(){
        isVisible(driver, toolbarMessageLoc);
        driver.findElement(toolbarMessageLoc).click();
        return new MessageLayer(driver);
    }

    public String textOfNoteNumber(int number){
        isVisible(driver, noteLoc(number));
        return driver.findElement(noteLoc(number)).getText();
    }

    private By noteLoc(int number){
        return By.xpath("//div[@class='feed-list __compact']/div["+ number +"]/descendant::div[@class='media-text_cnt']/div");
    }




}
