package com.automation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WaitUtil {

    /**
     * Fluent Wait: Polling for an element while ignoring specific exceptions.
     */
    public static WebElement fluentWait(WebDriver driver, final By locator, int timeoutInSeconds, int pollingInSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutInSeconds))
            .pollingEvery(Duration.ofSeconds(pollingInSeconds))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                // Returns the element only if it is displayed on the UI
                return element.isDisplayed() ? element : null; 
            }
        });
    }

    /**
     * Wait for an element to be visible in the DOM.
     */
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for an element to disappear from the UI.
     */
    public static boolean waitForInvisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait for an element to be clickable (useful for buttons and links).
     */
    public static WebElement waitForClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for specific text to be present within an element.
     */
    public static boolean waitForText(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}