package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import com.fashionette.TestUtil.TestData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerAccountPage extends TestBase {

    @FindBy(css = "span[title='Zum Warenkorb'] > .cart-amount")
    private WebElement itemsInCart;
    @FindBy(css = "span[title='Zum Warenkorb'] > .icon.icon--till")
    private WebElement cartIcon;
    @FindBy(css = ".account-personaldata > .account__headline.font-h1")
    private WebElement personalData;
    @FindBy(css = "[zipcode-mask] .account--address__action--update")
    private WebElement editPersonalData;
    @FindBy(name = "firstName")
    private WebElement name;
    @FindBy(name = "lastName")
    private WebElement surName;
    @FindBy(css = ".account--address__action.account--address__action--save")
    private WebElement saveData;
    @FindBy(css = ".account__welcome.font-size--hero.text__center")
    private WebElement verifyName;

    public CustomerAccountPage() {
        PageFactory.initElements(driver,this);
    }

    public void navigateToCart( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();
    }
    public String getNumberOfItemInCart(){
        webDriverWait.until(ExpectedConditions.visibilityOf(itemsInCart));
        return itemsInCart.getText();
    }
    public String modifyUserData(){
        personalData.click();
        editPersonalData.click();
        name.clear();
        name.sendKeys(TestData.firstName);
        surName.clear();
        surName.sendKeys(TestData.lastName);
        saveData.click();
        driver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyName));
        return verifyName.getText();

    }
}
