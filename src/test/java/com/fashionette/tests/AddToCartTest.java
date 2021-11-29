package com.fashionette.tests;

import com.fashionette.pages.*;
import com.fashionette.resources.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddToCartTest extends TestBase {

    private String actualMessageWhenItemAddedToCart;
    private String actualItemAddedToCart;
    private String expectedProductText;
    private List cartItems = new ArrayList();
    private boolean validateCart;

    public  AddToCartTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initializeDriver();
        CookiePage cookiePage =new CookiePage();
        cookiePage.acceptCookie();

    }

    @Test
    public void verifyProductAddedToCart(){
        HomePage homePage =new HomePage();
        AccessoriesPage accessoriesPage = new AccessoriesPage();
        SunglassesPage sunglassesPage = new SunglassesPage();
        ProductPage productPage = new ProductPage();
        LoginPage loginPage =new LoginPage();
        CustomerAccountPage customerAccountPage= new CustomerAccountPage();
        CartPage cartPage = new CartPage();

        homePage.getAccessories();
        accessoriesPage.getSunglasses();
        expectedProductText = sunglassesPage.getGucciModel001();
        productPage.moveItemToCart();
        actualMessageWhenItemAddedToCart = productPage.checkItemAdded();
        homePage.getLoginPage();
        loginPage.loginUser(property.getProperty("userEmail"), property.getProperty("userPassword"));
        actualItemAddedToCart = customerAccountPage.getNumberOfItemInCart();
        customerAccountPage.navigateToCart();
        cartItems =cartPage.navigateToCart();
        validateCart=cartPage.validateCart();

        Assert.assertEquals(actualMessageWhenItemAddedToCart,"BEREITS IM WARENKORB", "Item was not added to cart");
        Assert.assertNotEquals(actualItemAddedToCart,"0", "There are no items present in Cart");
        Assert.assertTrue(cartItems.contains(expectedProductText), "The item added was not present in Cart");
        Assert.assertTrue(validateCart, "Added Items are not present in cart");


    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
