package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

import com.automation.utilities.WaitUtil;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private WebDriver driver;

    private By loginTab = By.xpath("//a[contains(@href, '/login')]");
    private By emailFieldLocator = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void clickLoginTab() {
        logger.info("Checking if login is clicked");

        // 1. Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        // 2. Wait until the element is clickable, THEN click it
        wait.until(ExpectedConditions.elementToBeClickable(loginTab)).click();
    }
    
    public void enterEmail(String emailText) {
        logger.info("Checking if email is entered");
        // You must call the method through the WaitUtil class
        // Ensure fluentWait is declared as 'public static' in WaitUtil.java
        WebElement emailField = WaitUtil.fluentWait(driver,emailFieldLocator, 120, 1); 
        emailField.clear();
        emailField.sendKeys(emailText);
    }
    
    public void enterPassword(String password) {
        // It is better to use the wait here too to avoid NoSuchElementException
        WebElement passField = WaitUtil.fluentWait(driver,passwordField, 10, 1);
        passField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = WaitUtil.fluentWait(driver,loginButton, 10, 1);
        loginBtn.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}