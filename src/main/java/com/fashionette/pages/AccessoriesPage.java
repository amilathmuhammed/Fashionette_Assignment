package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccessoriesPage extends TestBase {

    @FindBy(css = "img[alt='Sonnenbrillen']")
    private WebElement sunglasses;
    @FindBy(css = "img[alt='Portemonnaies']")
    private WebElement wallets;
    @FindBy(css = "img[alt='Handyhüllen']")
    private WebElement phoneCases;

    public AccessoriesPage() {
        PageFactory.initElements(driver,this);
    }

    public void getSunglasses( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(sunglasses));
        sunglasses.click();
    }
    public void getWallets( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(wallets));
        wallets.click();
    }
    public void getPhoneCases( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(phoneCases));
        phoneCases.click();
    }
}
