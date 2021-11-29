package com.fashionette.tests;

import com.fashionette.pages.*;
import com.fashionette.resources.TestBase;
import com.fashionette.TestUtil.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplyVoucherTest extends TestBase {

    private String validCouponApplied;
    public  ApplyVoucherTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initializeDriver();
        CookiePage cookiePage =new CookiePage();
        cookiePage.acceptCookie();
    }
    @Test
    public void verifyVoucherApplied() {
        HomePage homePage = new HomePage();
        AccessoriesPage accessoriesPage = new AccessoriesPage();
        SunglassesPage sunglassesPage = new SunglassesPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        homePage.getAccessories();
        accessoriesPage.getSunglasses();
        sunglassesPage.getMichaelkorsModel3313();
        productPage.moveItemToCart();
        productPage.navigateToCart();
        validCouponApplied = cartPage.applyVoucherCode();

        Assert.assertTrue(validCouponApplied.contains((TestData.couponCode).toUpperCase()), "Coupon code did not applied");

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
