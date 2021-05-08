package com.zhiCong.plaform.base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseFlow implements WebElement {
    private AppiumDriver appiumDriver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;

    public BaseFlow(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        this.webDriverWait = (WebDriverWait) new WebDriverWait(appiumDriver,20,10).ignoring(NoClassDefFoundError.class);
    }


    public boolean displayed(WebElement webElement, Integer... timeInSeconds){
        try{
            return true;
//            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElement)).();
        }catch (Exception e){
            return false;
        }
    }
}
