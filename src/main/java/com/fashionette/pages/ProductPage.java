package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends TestBase {

    @FindBy(css = "form[method='post'] .btn__content")
    private WebElement addToCart;
    @FindBy(css = "span[title='Zum Warenkorb'] > .icon.icon--till")
    private WebElement cartIcon;
    @FindBy(css = "form[method='post'] .btn__content")
    private WebElement whetherItemAdded;
    @FindBy(css = ".account-personaldata > .account__headline.font-h1")
    private WebElement personalData;


    public ProductPage() {
        PageFactory.initElements(driver,this);
    }

    public void moveItemToCart( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
    }

    public String checkItemAdded( ){
        driver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.visibilityOf(whetherItemAdded));
        return whetherItemAdded.getText();
    }
    public void navigateToCart( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();
    }

}
