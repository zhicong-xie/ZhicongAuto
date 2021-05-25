package com.zhiCong.plaform.base;

import com.zhiCong.plaform.base.config.DriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFlow {

    private final int defaultWaitingTime = 5;

    private AppiumDriver appiumDriver;
    private DriverConfig driverConfig;

    int startX;
    int startY;
    int endX;
    int endY;

    public BaseFlow(){
        driverConfig = DriverConfig.getInstance();
        appiumDriver = DriverConfig.getDriver();
    }


    protected boolean checkForElement(WebElement webElement){
        WebDriverWait w=new WebDriverWait(appiumDriver,defaultWaitingTime);
        try{
            w.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    protected boolean checkForElement(WebElement webElement, Integer timeInSeconds){
        WebDriverWait w=new WebDriverWait(appiumDriver,defaultWaitingTime);
        try{
            w.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    protected void waitForElement(WebElement webElement){
        try{
            WebDriverWait w=new WebDriverWait(appiumDriver,defaultWaitingTime);
            w.until(ExpectedConditions.visibilityOf(webElement));
        }catch (Exception e){
        }
    }

    protected void waitForElements(List<WebElement> webElements){
        try{
            WebDriverWait w=new WebDriverWait(appiumDriver,defaultWaitingTime);
            w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
        }catch (Exception e){
        }
    }

    protected void waitForElements(List<WebElement> webElements, Integer timeInSeconds){
        try{
            WebDriverWait w=new WebDriverWait(appiumDriver,timeInSeconds);
            w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
        }catch (Exception e){
        }
    }

    protected void waitForElement(WebElement webElement, Integer timeInSeconds){
        try{
            WebDriverWait w=new WebDriverWait(appiumDriver,timeInSeconds);
            w.until(ExpectedConditions.visibilityOf(webElement));
        }catch (Exception e){
        }
    }

    protected void sleep(Long ms){
        try{
            Thread.sleep(ms);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    protected void swipeUp(){
        TouchAction touchAction = new TouchAction(appiumDriver);
        startX = endX = (int)appiumDriver.manage().window().getSize().width/2;
        startY = (int)appiumDriver.manage().window().getSize().height*5/8;
        endY = (int)appiumDriver.manage().window().getSize().height/8;
        new TouchAction(appiumDriver)
                .press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX,endY))
                .release()
                .perform();
    }
}
