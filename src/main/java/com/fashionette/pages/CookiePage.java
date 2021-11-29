package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookiePage extends TestBase {

    @FindBy(id = "uc-btn-accept-banner")
    private WebElement cookie;


    public CookiePage() {
        PageFactory.initElements(driver,this);
    }

    public void acceptCookie() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();
    }
}
