package scenarios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractTest {
    protected final WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void init() {
        driver.get("https://ok.ru");
    }

    @AfterEach
    public void close() {
        driver.close();
    }
}
