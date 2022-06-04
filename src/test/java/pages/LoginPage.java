package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.User;

public class LoginPage implements LoadableComponent {
    private final WebDriver driver;

    private final By byEmail    = By.id("field_email");
    private final By byPassword = By.id( "field_password");
    private final By byButton   = By.xpath("//*[@class='login-form-actions']/input");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login(User user){
        isComponentLoaded(driver, byEmail, DEFAULT_TIMEOUT);
        isComponentLoaded(driver, byPassword, DEFAULT_TIMEOUT);
        isComponentLoaded(driver, byButton, DEFAULT_TIMEOUT);

        driver.findElement(byEmail).sendKeys(user.getLogin());
        driver.findElement(byPassword).sendKeys(user.getPassword());
        driver.findElement(byButton).click();

        return new MainPage(driver);
    }

}
