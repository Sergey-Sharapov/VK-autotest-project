package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public interface LoadableComponent {
    long DEFAULT_TIMEOUT = 5;

    default WebElement isComponentLoaded(WebDriver driver, By locator, long seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    default WebElement isComponentLoaded(WebDriver driver, By locator){
        return isComponentLoaded(driver, locator, DEFAULT_TIMEOUT);
    }

    default WebElement isComponentLoaded(WebElement element, By locator, long seconds) {
        Wait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500L))
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebElement, WebElement>() {
            public WebElement apply(WebElement element) {
                return element.findElement(locator);
            }
        });
    }

    default WebElement isComponentLoaded(WebElement element, By locator) {
        return isComponentLoaded(element, locator, DEFAULT_TIMEOUT);
    }
}
