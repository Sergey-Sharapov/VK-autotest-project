package scenarios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class AbstractTest {
    protected final WebDriver driver = new ChromeDriver();
    protected LoginPage loginPage;

    @BeforeEach
    public void init() {
        driver.get("https://ok.ru");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void close() {
        driver.close();
    }
}
