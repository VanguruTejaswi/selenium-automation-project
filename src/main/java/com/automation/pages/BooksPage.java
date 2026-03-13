package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.utilities.WaitUtil;

public class BooksPage {
    private static final Logger logger = LoggerFactory.getLogger(BooksPage.class);

    private WebDriver driver;



    // Updated XPath to use contains() for better stability
    private By firstPrizePiesLink = By.linkText("First Prize Pies");

    public BooksPage(WebDriver driver){
        this.driver = driver;
        // You no longer need 'this.waitUtil = new WaitUtil(driver);' 
        // because we are calling the method statically.
    }

    public boolean isBookVisible(){
        logger.info("Checking if book is visible");
        // Call the method using the Class name: WaitUtil.fluentWait
        WebElement element = WaitUtil.fluentWait(driver, firstPrizePiesLink, 85, 2);
        return element.isDisplayed();
    }

    public ProductDetailsPage clickBook(){
        logger.info("Checking for book click");
        // Pass 'driver' as the first argument to satisfy the new static method signature
        WaitUtil.fluentWait(driver, firstPrizePiesLink, 80, 2).click();
        return new ProductDetailsPage(driver);
    }
}