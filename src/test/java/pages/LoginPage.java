package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.User;

public class LoginPage extends AbstractPage {
    private final WebDriver driver;

    private final By byEmailId     = By.id("field_email");
    private final By byPasswordId  = By.id( "field_password");
    private final By byButtonXpath = By.xpath("//*[@class='login-form-actions']/input");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login(User user){
        isLoaded();

        driver.findElement(byEmailId).sendKeys(user.getLogin());
        driver.findElement(byPasswordId).sendKeys(user.getPassword());
        driver.findElement(byButtonXpath).click();

        return new MainPage(driver);
    }

    @Override
    public void isLoaded() {
        isComponentLoaded(driver, byEmailId, DEFAULT_TIMEOUT);
        isComponentLoaded(driver, byPasswordId, DEFAULT_TIMEOUT);
        isComponentLoaded(driver, byButtonXpath, DEFAULT_TIMEOUT);
    }
}
