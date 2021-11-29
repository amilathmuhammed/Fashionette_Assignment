package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(css = "img[alt='Accessoires']")
    private WebElement accessories;
    @FindBy(css = "img[alt='Uhren']")
    private WebElement watches;
    @FindBy(css = "img[alt='Beauty']")
    private WebElement beautyProducts;
    @FindBy(css = "a[title='Einloggen'] > .icon.icon--user")
    private WebElement navigateToLoginPage;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }


    public void getAccessories( ){
        accessories.click();
    }

    public void getBeautyProducts( ){
        beautyProducts.click();

    }
    public void getWatches( ){
        watches.click();

    }
    public void getLoginPage(){
        navigateToLoginPage.click();

    }
}
