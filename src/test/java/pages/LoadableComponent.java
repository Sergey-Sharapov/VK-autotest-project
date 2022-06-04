package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface LoadableComponent {
    long DEFAULT_TIMEOUT = 5;

    default void isComponentLoaded(WebDriver driver, By locator, long seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    default void isComponentLoaded(WebDriver driver, By locator){
        isComponentLoaded(driver, locator, DEFAULT_TIMEOUT);
    }
}
