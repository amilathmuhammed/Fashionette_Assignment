package com.fashionette.pages;

import com.fashionette.resources.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SunglassesPage extends TestBase {

    @FindBy(css = "a[title='Michael Kors, MK 0MK2079U 61 333313']  .product--list__item__description > .product--list__item__name ")
    private WebElement mkModel333313;
    @FindBy(css = "a[title='Gucci, GG0163S 51 003']  .product--list__item__description > .product--list__item__name ")
    private WebElement ggModel003;
    @FindBy(css = "a[title='Gucci, GG0417SK 56 001']  .product--list__item__description > .product--list__item__name ")
    private WebElement ggModel001;

    public String actualTextOfProdut;

    public SunglassesPage() {
        PageFactory.initElements(driver,this);
    }

    public String getMichaelkorsModel3313( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(mkModel333313));
        actualTextOfProdut =mkModel333313.getText();
        mkModel333313.click();
        return actualTextOfProdut;
    }
    public String getGucciModel003( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(ggModel003));
        actualTextOfProdut = ggModel003.getText();
        ggModel003.click();
        return actualTextOfProdut;
    }
    public String getGucciModel001( ){
        webDriverWait.until(ExpectedConditions.visibilityOf(ggModel001));
        actualTextOfProdut = ggModel001.getText();
        ggModel001.click();
        return actualTextOfProdut;
    }
}
