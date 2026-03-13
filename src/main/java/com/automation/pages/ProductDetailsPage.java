package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.utilities.WaitUtil;

public class ProductDetailsPage {

    private WebDriver driver;

    // Use contains() for better XPath stability
    private By productTitle = By.xpath("//h1[contains(text(),'First Prize Pies')]");
    private By addToCart = By.id("add-to-cart-button-37");
    private By successMessage = By.cssSelector("#bar-notification, .bar-notification");
    private By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        // Removed: this.waitUtil = new WaitUtil(driver);
    }

    public boolean productTitleIsDisplayed() {
        // Static call passing the driver
        WebElement element = WaitUtil.fluentWait(driver, productTitle, 10, 2);
        return element.isDisplayed();
    }

    public void addToCartClick() {
        // Ensure waitForVisibility is also static in your WaitUtil.java
        WebElement button = WaitUtil.waitForVisibility(driver, addToCart, 10);
        
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
    }

    public boolean successMessageIsDisplayed() {
        try {
            return WaitUtil.waitForVisibility(driver, successMessage, 10).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public CartPage clickShoppingCart() {
        // Wait for notification to appear, then click the link
        WaitUtil.waitForVisibility(driver, successMessage, 10);
        WaitUtil.fluentWait(driver, shoppingCartLink, 10, 2).click();
        
        // Optional: wait for notification to disappear to avoid overlay issues
        WaitUtil.waitForInvisibility(driver,successMessage, 5);
        
        return new CartPage(driver);
    }
}