package scenarios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

public class AbstractTest {
    protected final WebDriver driver = new ChromeDriver();
    protected LoginPage loginPage = new LoginPage(driver);
    protected MainPage mainPage;

    @BeforeEach
    public void init() {
        driver.get("https://ok.ru");
    }

    @AfterEach
    public void close() {
        driver.close();
    }
}
