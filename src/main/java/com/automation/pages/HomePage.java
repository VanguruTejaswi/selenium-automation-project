package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.utilities.WaitUtil;

public class HomePage {

    private WebDriver driver;

    private By logoImage = By.xpath("//img[contains(@src,'logo')]");
    private By booksMenu = By.xpath("//a[contains(text(),'Books')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
        // Removed: this.waitUtil = new WaitUtil(driver);
    }

    // Validation
    public boolean isLogoDisplayed(){
        // Using static call: WaitUtil.fluentWait(driver, ...)
        WebElement element = WaitUtil.fluentWait(driver, logoImage, 120, 2);
        return element.isDisplayed();
    }

    // Navigation
    public BooksPage clickBooksMenu(){
        // Passing driver as the first parameter
        WaitUtil.fluentWait(driver, booksMenu, 80, 2).click();
        return new BooksPage(driver);
    }
}