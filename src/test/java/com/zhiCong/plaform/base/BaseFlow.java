package com.zhiCong.plaform.base;

import com.zhiCong.plaform.base.config.AndroidDriverConfig;
import com.zhiCong.plaform.base.config.IosDriverConfig;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFlow {

    private AndroidDriverConfig androidDriverConfig;
    private AndroidDriver androidDriver;
    private IosDriverConfig iosDriverConfig;
    private IOSDriver iosDriver;

    int startX;
    int startY;
    int endX;
    int endY;

    public BaseFlow(){
        if ("ios".equals(System.getProperty("platform"))){
            iosDriverConfig = IosDriverConfig.getInstance();
            iosDriver = IosDriverConfig.getDriver();
        }else {
            androidDriverConfig = AndroidDriverConfig.getInstance();
            androidDriver = AndroidDriverConfig.getDriver();
        }
    }


    protected boolean checkForElement(WebElement webElement){

        if ("ios".equals(System.getProperty("platform"))){
            WebDriverWait w=new WebDriverWait(iosDriver,5);
            try{
                w.until(ExpectedConditions.visibilityOf(webElement));
                return webElement.isDisplayed();
            }catch (Exception e){
                return false;
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(androidDriver,5);
                w.until(ExpectedConditions.visibilityOf(webElement));
                return webElement.isDisplayed();
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

    protected boolean checkForElement(WebElement webElement, Integer timeInSeconds){

        if ("ios".equals(System.getProperty("platform"))){
            WebDriverWait w=new WebDriverWait(iosDriver,timeInSeconds);
            try{
                w.until(ExpectedConditions.visibilityOf(webElement));
                return webElement.isDisplayed();
            }catch (Exception e){
                return false;
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(androidDriver,timeInSeconds);
                w.until(ExpectedConditions.visibilityOf(webElement));
                return webElement.isDisplayed();
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

    protected void waitForElement(WebElement webElement){
        if ("ios".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(iosDriver,5);
                w.until(ExpectedConditions.visibilityOf(webElement));
            }catch (Exception e){
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(androidDriver,5);
                w.until(ExpectedConditions.visibilityOf(webElement));
            }catch (Exception e){
            }
        }
    }

    protected void waitForElements(List<WebElement> webElements){
        if ("ios".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(iosDriver,5);
                w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
            }catch (Exception e){
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(androidDriver,5);
                w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
            }catch (Exception e){
            }
        }
    }

    protected void waitForElements(List<WebElement> webElements, Integer timeInSeconds){
        if ("ios".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(iosDriver,timeInSeconds);
                w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
            }catch (Exception e){
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(androidDriver,timeInSeconds);
                w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
            }catch (Exception e){
            }
        }
    }

    protected void waitForElement(WebElement webElement, Integer timeInSeconds){
        if ("ios".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(iosDriver,timeInSeconds);
                w.until(ExpectedConditions.visibilityOf(webElement));
            }catch (Exception e){
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(androidDriver,timeInSeconds);
                w.until(ExpectedConditions.visibilityOf(webElement));
            }catch (Exception e){
            }
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
        if ("ios".equals(System.getProperty("platform"))){
            TouchAction touchAction = new TouchAction(iosDriver);
            startX = endX = (int)iosDriver.manage().window().getSize().width/2;
            startY = (int)iosDriver.manage().window().getSize().height*5/8;
            endY = (int)iosDriver.manage().window().getSize().height/8;
            new TouchAction(iosDriver)
                    .press(PointOption.point(startX,startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX,endY))
                    .release()
                    .perform();

        }else if ("android".equals(System.getProperty("platform"))){
            TouchAction touchAction = new TouchAction(androidDriver);
            startX = endX = (int)androidDriver.manage().window().getSize().width/2;
            startY = (int)androidDriver.manage().window().getSize().height*5/8;
            endY = (int)androidDriver.manage().window().getSize().height/8;
            new TouchAction(androidDriver)
                    .press(PointOption.point(startX,startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX,endY))
                    .release()
                    .perform();
        }
    }

    protected void clickSystemBackButton(){
         if ("android".equals(System.getProperty("platform"))){
            androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }
}
