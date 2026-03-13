package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.utilities.WaitUtil;

public class CartPage {

    private WebDriver driver;

    // Locators remain the same
    // private By bookName = By.xpath("//a[contains(text(),'First Prize Pies')]");
    private By giftWrapDropdown = By.id("checkout_attribute_1");
    private By totalAmount = By.cssSelector(".value-summary");
    private By termsOfServiceCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver = driver;
        // Removed the 'new WaitUtil' line as it is no longer needed for static calls
    }

    // public boolean isBookNameDisplayed() {
    //     // Pass 'driver' as the first argument to the static method
    //     return WaitUtil.fluentWait(driver, bookName, 10, 2).isDisplayed();
    // }

    public void selectGiftWrapping(int index) {
        // Pass 'driver' as the first argument
        WebElement element = WaitUtil.fluentWait(driver, giftWrapDropdown, 80, 2);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public boolean isTotalAmountDisplayed() {
        return WaitUtil.fluentWait(driver, totalAmount, 80, 2).isDisplayed();
    }

    
    public void clickTermsOfService() {
        WaitUtil.fluentWait(driver, termsOfServiceCheckbox, 80, 2).click();
    }

    public CheckOutPage clickCheckout(){
        WaitUtil.fluentWait(driver, checkoutButton, 80, 2).click();
        return new CheckOutPage(driver);
    }
}