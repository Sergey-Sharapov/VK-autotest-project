import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoTests {

    @Test
    public void login()
    {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage= new LoginPage(driver);
        User user = new User("Тест Тестов",
                                "79681897921",
                                "test2022");

        driver.get("https://ok.ru/");
        Assertions.assertTrue(loginPage.tryLogin(user).isMain(user));
    }
}
