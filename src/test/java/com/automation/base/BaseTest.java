package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    // Ensure this is NOT static unless you are doing parallel testing specifically
    protected WebDriver driver; 

    @BeforeMethod
    public void setUp() {
        // 1. Initialize the driver
        driver = new ChromeDriver();
        
        // 2. Set timeouts to prevent the "expected [true] but found [false]" error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // 3. Maximize and navigate
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/"); 
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}