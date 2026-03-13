package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.BooksPage;
import com.automation.pages.CartPage;
import com.automation.pages.CheckOutPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductDetailsPage;

public class CheckOutTest extends BaseTest {

    @Test(priority = 3)
    public void verifyCheckoutFlow() {

        // Home Page
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isLogoDisplayed(),
                "Home page not loaded");

        // Navigate to Books
        BooksPage books = home.clickBooksMenu();

        // Click Book
        ProductDetailsPage product = books.clickBook();

        // Add To Cart
        product.addToCartClick();
        CartPage cart = product.clickShoppingCart();

        // Accept terms
        // cart.clickTermsOfService();

        // Click Checkout
        CheckOutPage checkout = cart.clickCheckout();

        // Fill Billing Details
        checkout.selectCountry(1);
        checkout.selectState(1);
        checkout.enterCity("Hyderabad");
        checkout.enterAddress("Madhapur");
        checkout.enterZipCode("500081");
        checkout.enterPhoneNumber("9876543210");

        // Continue
        checkout.clickContinue();
    }
}
