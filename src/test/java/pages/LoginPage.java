package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.User;

public class LoginPage implements VisibleComponent {
    private final WebDriver driver;

    private final By byEmail    = By.id("field_email");
    private final By byPassword = By.id( "field_password");
    private final By byButton   = By.xpath("//*[@class='login-form-actions']/input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login(User user){
        isVisible(driver, byEmail);
        driver.findElement(byEmail).sendKeys(user.getLogin());

        isVisible(driver, byPassword);
        driver.findElement(byPassword).sendKeys(user.getPassword());

        isVisible(driver, byButton);
        driver.findElement(byButton).click();

        return new MainPage(driver);
    }

}
