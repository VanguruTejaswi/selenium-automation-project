package com.automation.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;


public class LoginTest extends BaseTest{

@Test(priority = 1)
public void verifyLogin() {
   
    LoginPage loginpage = new LoginPage(driver);

    loginpage.clickLoginTab();
    loginpage.enterEmail("testuser@example.com");
    loginpage.enterPassword("Test@123");
    loginpage.clickLogin();

    String expectedUrl = "https://demo.nopcommerce.com/login";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(expectedUrl), "Login failed: URL mismatch!");
}
}
