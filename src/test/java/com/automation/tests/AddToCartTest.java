package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.BooksPage;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductDetailsPage;

public class AddToCartTest extends BaseTest {

    @Test(priority = 2)
    public void verifyAddToCartFlow() {

        LoginPage loginpage = new LoginPage(driver);

         loginpage.clickLoginTab();
    loginpage.enterEmail("testuser@example.com");
    loginpage.enterPassword("Test@123");
    loginpage.clickLogin();

        // Step 1: Home Page
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isLogoDisplayed(),
                "Home page logo is not displayed");

        // Step 2: Navigate to Books
        BooksPage books = home.clickBooksMenu();
        Assert.assertTrue(books.isBookVisible(),
                "Book is not visible on Books page");

        // Step 3: Click Book
        ProductDetailsPage product = books.clickBook();
        Assert.assertTrue(product.productTitleIsDisplayed(),
                "Product title not displayed");

        product.addToCartClick();
        

        // Step 4: Add To Cart
        boolean isMessageVisible = product.successMessageIsDisplayed();
        Assert.assertTrue(isMessageVisible, "Add to cart success message (green bar) did not appear after clicking.");


        // Step 5: Go To Cart
        CartPage cart = product.clickShoppingCart();
        Assert.assertTrue(cart.isTotalAmountDisplayed(),
                "Total amount not displayed");
    
}
}
