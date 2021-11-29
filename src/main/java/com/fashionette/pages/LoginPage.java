package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends TestBase {

    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(css = "#form-login .btn__submit")
    private WebElement login;

    private int count = 0;
    private boolean clicked = false;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }


    public void loginUser(String userEmail, String userPassword ){
        while (count < 2 && !clicked)
        {
            try
            {
                email.sendKeys(userEmail);
                password.sendKeys(userPassword);
                clicked = true;
            }
            catch (StaleElementReferenceException e)
            {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count+1;
            }
        }

        login.click();

    }
}