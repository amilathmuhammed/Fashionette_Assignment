package com.fashionette.resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties property;
    public static WebDriverWait webDriverWait;
    public static Actions action;

    public TestBase(){
        try {
            property = new Properties();
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/fashionette/resources/config.properties/");
            property.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeDriver()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(property.getProperty("url"));
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 20);
        action = new Actions(driver);
    }
    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;


    }
}
