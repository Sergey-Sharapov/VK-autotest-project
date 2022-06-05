package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import utils.User;

public class MainPage implements LoadableComponent {
    private final WebDriver driver;
    private final By fullnameLoc = By.xpath("//div[@class='nav-side __navigation __user-main']/div[1]/a/div");
    private final By noteFieldLoc = By.xpath("//div[@id='hook_Block_PostingForm']/descendant::div[@class='pf-head_itx']/a");
    private final By noteInputFieldLoc = By.xpath("//div[@id='hook_Block_PopLayerMediaTopic']/descendant::div[@class='posting_cnt']/descendant::div[@class='posting_itx-w']/div[2]");
    private final By postButtonLoc = By.xpath("//div[@class='posting_submit button-pro']");

    private final By toolbarMessageLoc = By.xpath("//ul[@class='toolbar_nav']/li[@data-l='t,messages']/div[1]");
    private final By messageLayerLoc = By.id("msg_layer_wrapper");
    //private final By byPostButtonXpath = By.xpath("//div[@class='feed-list __compact']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isUserNameCorrect(User user){
        isComponentLoaded(driver, fullnameLoc);
        return driver.findElement(fullnameLoc).getText().equals(user.getFullName());
    }

    public MainPage openPostingField() {
        isComponentLoaded(driver, noteFieldLoc);
        driver.findElement(noteFieldLoc).click();
        return new MainPage(driver);
    }

    public MainPage sendTextToNewPost(String text){
        isComponentLoaded(driver, noteInputFieldLoc);
        driver.findElement(noteInputFieldLoc).clear();
        driver.findElement(noteInputFieldLoc).sendKeys(text);
        return new MainPage(driver);
    }

    public MainPage clickPostButton(){
        isComponentLoaded(driver, postButtonLoc);
        driver.findElement(postButtonLoc).click();
        return new MainPage(driver);
    }

    public String textOfPostNumber(int number){
        isComponentLoaded(driver, postLoc(number));
        return driver.findElement(postLoc(number)).getText();
    }

    private By postLoc(int number){
        return By.xpath("//div[@class='feed-list __compact']/div["+ number +"]/descendant::div[@class='media-text_cnt']/div");
    }

    public MessageLayer openMessageLayer(){
        isComponentLoaded(driver, toolbarMessageLoc);
        driver.findElement(toolbarMessageLoc).click();
        return new MessageLayer(driver);
    }


}
