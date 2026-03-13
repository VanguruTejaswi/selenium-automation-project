package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.utilities.WaitUtil;

public class CheckOutPage {

    private WebDriver driver;

    private By countryName = By.id("BillingNewAddress_CountryId");
    private By stateName = By.id("BillingNewAddress_StateProvinceId");
    private By cityName = By.id("BillingNewAddress_City");
    private By addressField = By.id("BillingNewAddress_Address1");
    private By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private By continueButton = By.cssSelector(".new-address-next-step-button");

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        // The 'this.waitUtil = new WaitUtil(driver);' line is removed
    }

    public void selectCountry(int index){
        // Static call: WaitUtil.fluentWait(driver, ...)
        WebElement element = WaitUtil.fluentWait(driver, countryName, 80, 2);
        new Select(element).selectByIndex(index);
    }

    public void selectState(int index){
        WebElement element = WaitUtil.fluentWait(driver, stateName, 80, 2);
        new Select(element).selectByIndex(index);
    }

    public void enterCity(String city){
        WaitUtil.fluentWait(driver, cityName, 80, 2).sendKeys(city);
    }

    public void enterAddress(String address){
        WaitUtil.fluentWait(driver, addressField, 80, 2).sendKeys(address);
    }

    public void enterZipCode(String zip){
        WaitUtil.fluentWait(driver, zipCode, 80, 2).sendKeys(zip);
    }

    public void enterPhoneNumber(String phone){
        WaitUtil.fluentWait(driver, phoneNumber, 80, 2).sendKeys(phone);
    }

    public void clickContinue(){
        WaitUtil.fluentWait(driver, continueButton, 80, 2).click();
    }
}