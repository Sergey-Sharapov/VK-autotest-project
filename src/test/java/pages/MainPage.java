package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.User;

public class MainPage extends AbstractPage {
    private final WebDriver driver;
    private final By byFullnameXpath = By.xpath("//div[@class='nav-side __navigation __user-main']/div[1]/a/div");
    private final By byNoteFieldXpath = By.xpath("//div[@id='hook_Block_PostingForm']/descendant::div[@class='pf-head_itx']/a");
    private final By byNoteInputFieldXpath = By.xpath("//div[@id='hook_Block_PopLayerMediaTopic']/descendant::div[@class='posting_cnt']/descendant::div[@class='posting_itx-w']/div[2]");
    private final By byPostButtonXpath = By.xpath("//div[@class='posting_submit button-pro']");
    //private final By byPostButtonXpath = By.xpath("//div[@class='feed-list __compact']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isUserNameCorrect(User user){
        isComponentLoaded(driver, byFullnameXpath, DEFAULT_TIMEOUT);
        return driver.findElement(byFullnameXpath).getText().equals(user.getFullName());
    }

    public MainPage openPostingField() {
        isComponentLoaded(driver, byNoteFieldXpath, DEFAULT_TIMEOUT);
        driver.findElement(byNoteFieldXpath).click();
        return new MainPage(driver);
    }

    public MainPage sendTextToNewPost(String text){
        isComponentLoaded(driver, byNoteInputFieldXpath, DEFAULT_TIMEOUT);
        driver.findElement(byNoteInputFieldXpath).sendKeys(text);
        return new MainPage(driver);
    }

    public MainPage clickPostButton(){
        isComponentLoaded(driver, byPostButtonXpath, DEFAULT_TIMEOUT);
        driver.findElement(byPostButtonXpath).click();
        return new MainPage(driver);
    }

    public String textOfPostNumber(int number){
        isComponentLoaded(driver, byPostXpath(number), DEFAULT_TIMEOUT);
        return driver.findElement(byPostXpath(number)).getText();
    }

    @Override
    public void isLoaded() {
    }

    private By byPostXpath(int number){
        return By.xpath("//div[@class='feed-list __compact']/div["+ number +"]/descendant::div[@class='media-text_cnt']/div");
    }
}
