package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import com.fashionette.TestUtil.TestData;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.ArrayList;
import java.util.List;

public class CartPage extends TestBase {

    @FindBy(css = ".cart-item--name")
    private List<WebElement> itemsInCart;
    @FindBy(id = "checkout-start")
    private WebElement toAddress;
    @FindBy(css = ".cart__sum__voucher-link")
    private WebElement couponCode;
    @FindBy(name = "voucherCode")
    private WebElement applyCode;
    @FindBy(css = "#form-cart-voucher .btn__submit")
    private WebElement submitCouponCode;
    @FindBy(css = "tr:nth-of-type(3) > .text__left.typography__type-2")
    private WebElement checkCouponCode;
    @FindBy(css = ".address-delete__content__actions")
    private WebElement verifyCouponApplied;


    private List<String> productsInCart= new ArrayList<String>();
    private int count = 0;
    private boolean clicked = false;

    public CartPage() {
        PageFactory.initElements(driver,this);
    }
    public List<String> navigateToCart( ){
        while (count < 2 && !clicked)
        {
            try
            {
                for(WebElement products:itemsInCart) {
                    productsInCart.add(products.getText());
                }
                clicked = true;
            }
            catch (StaleElementReferenceException e)
            {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count+1;
            }
        }

       return productsInCart;
    }
    public boolean validateCart(){

        return toAddress.isEnabled();
    }


    public String applyVoucherCode(){
        couponCode.click();
        applyCode.sendKeys(TestData.couponCode);
        submitCouponCode.click();
        while (count < 2 && !clicked)
        {
            try
            {
                checkCouponCode.click();
                webDriverWait.until(ExpectedConditions.visibilityOf(verifyCouponApplied));
                clicked = true;
            }
            catch (StaleElementReferenceException e)
            {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count+1;
            }
        }
        return verifyCouponApplied.getText();

    }

}
