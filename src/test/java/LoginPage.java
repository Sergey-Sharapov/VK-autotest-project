import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private String loginId = "field_email";
    private String passwordId = "field_password";
    private String xpathButton = "//*[@class='login-form-actions']/input";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage tryLogin(User user){
        driver.findElement(By.id(loginId)).sendKeys(user.getLogin());
        driver.findElement(By.id(passwordId)).sendKeys(user.getPassword());
        driver.findElement(By.xpath(xpathButton)).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new MainPage(driver);
    }
}
