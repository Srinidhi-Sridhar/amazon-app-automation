package com.amazon.test;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AmazonBasicTest extends BaseTestClass {
    LoginPage loginPage;
    SignInToYourAccountPage signInToYourAccountPage;
    SearchPage searchPage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    CartPage cartPage;


    //*1.Searching for a product adding it to Cart and verifying the details

    @BeforeTest
    public void beforeTest() {
        signInToYourAccountPage = new SignInToYourAccountPage();
        signInToYourAccountPage.clickOnAsExistingUser();
        loginPage = new LoginPage();
        loginPage.loginIn();
    }

    @Test(description = "Searching for a Product and Verifying the details in the Cart")
    public void verifyProdDescPrice() {
        searchPage = new SearchPage();
        searchPage.verifyLogin();
        searchPage.searchProduct();
        searchPage.swipeOnce();
        searchResultPage = new SearchResultPage();
        searchResultPage.clickOnProdBasedOnIndex(1);
        productPage = new ProductPage();
        String descriptionInProductPage = productPage.prodDescCheck();
        String priceInProductPage = productPage.prodPriceCheck();
        productPage.clickOnAddToCart();
        productPage.openCart();
        cartPage = new CartPage();
        String descriptionInCart = cartPage.getProductDescription();
        String priceInCart = cartPage.getProductPrice();
        Assert.assertEquals(descriptionInProductPage, descriptionInCart, "Description not matching");
        Assert.assertEquals(priceInProductPage, priceInCart, "Price not matching");
    }
}
