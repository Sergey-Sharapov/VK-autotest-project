package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.User;

public class MainPage extends AbstractPage {
    private final WebDriver driver;
    private final By byFullnameXpath = By.xpath("//div[@class='nav-side __navigation __user-main']/div[1]/a/div");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isUserNameCorrect(User user){
        isLoaded();
        return driver.findElement(byFullnameXpath).getText().equals(user.getFullName());
    }

    @Override
    public void isLoaded() {
        isComponentLoaded(driver, byFullnameXpath, DEFAULT_TIMEOUT);
    }
}
