package com.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static WebDriver driver;

public static WebDriver getDriver() {
    ChromeOptions options = new ChromeOptions();

    // This is the "magic" flag that hides the navigator.webdriver = true property
    options.addArguments("--disable-blink-features=AutomationControlled");

    // Optional: Use a real user agent
    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");


    if (driver==null){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    return driver;
}
  public static void quitDriver() {
    if (driver != null) {
        driver.quit();
    }
  }  
}
