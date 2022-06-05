package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface VisibleComponent extends LoadableComponent{

    default void isVisible(WebDriver driver, By locator, long seconds) throws NoSuchElementException{
        if(!isComponentLoaded(driver, locator, seconds).isDisplayed())
            throw new NoSuchElementException("Element: "+locator+" isn't visible.");
    }

    default void isVisible(WebDriver driver, By locator) throws NoSuchElementException{
        if(!isComponentLoaded(driver, locator).isDisplayed())
            throw new NoSuchElementException("Element: "+locator+" isn't visible.");
    }

    default void isVisible(WebElement element, By locator, long seconds) throws NoSuchElementException{
        if(!isComponentLoaded(element, locator, seconds).isDisplayed())
            throw new NoSuchElementException("Element: "+locator+" isn't visible.");
    }

    default void isVisible(WebElement element, By locator) throws NoSuchElementException{
        if(!isComponentLoaded(element, locator).isDisplayed())
            throw new NoSuchElementException("Element: "+locator+" isn't visible.");
    }
}
