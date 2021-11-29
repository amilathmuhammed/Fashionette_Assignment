package com.fashionette.tests;

import com.fashionette.pages.CookiePage;
import com.fashionette.pages.CustomerAccountPage;
import com.fashionette.pages.HomePage;
import com.fashionette.pages.LoginPage;
import com.fashionette.resources.TestBase;
import com.fashionette.TestUtil.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ModifyUserDataTest extends TestBase {

    private String verifyData;

    public  ModifyUserDataTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initializeDriver();
        CookiePage cookiePage =new CookiePage();
        cookiePage.acceptCookie();

    }
    @Test
    public void verifyUserDataGetModified() {
        HomePage homePage =new HomePage();
        LoginPage loginPage =new LoginPage();
        CustomerAccountPage customerAccountPage = new CustomerAccountPage();

        homePage.getLoginPage();
        loginPage.loginUser(property.getProperty("userEmail"), property.getProperty("userPassword"));
        verifyData =customerAccountPage.modifyUserData();

        Assert.assertTrue(verifyData.contains(TestData.firstName), "user data is not modified ");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
