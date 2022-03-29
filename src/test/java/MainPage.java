import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private final String xpathFullname = "//div[@id='hook_Block_Navigation']/div/div/a[1]/div";

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isMain(User user){
        return driver.findElement(By.xpath(xpathFullname)).getText().equals(user.getFullname());
    }
}
