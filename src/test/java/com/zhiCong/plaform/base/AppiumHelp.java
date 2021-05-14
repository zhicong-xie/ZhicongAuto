package com.zhiCong.plaform.base;

import com.zhiCong.plaform.base.config.AndroidDriverConfig;
import com.zhiCong.plaform.base.config.IosDriverConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumHelp {

    protected boolean checkForElement(WebElement webElement){

        if ("ios".equals(System.getProperty("platform"))){
            WebDriverWait w=new WebDriverWait(IosDriverConfig.getDriver(),5);
            try{
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
            }catch (Exception e){
                return false;
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(AndroidDriverConfig.getDriver(),5);
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

    protected boolean checkForElement(WebElement webElement, Integer timeInSeconds){

        if ("ios".equals(System.getProperty("platform"))){
            WebDriverWait w=new WebDriverWait(IosDriverConfig.getDriver(),timeInSeconds);
            try{
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
            }catch (Exception e){
                return false;
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(AndroidDriverConfig.getDriver(),timeInSeconds);
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

    protected void waitForElement(WebElement webElement){
        if ("ios".equals(System.getProperty("platform"))){
            WebDriverWait w=new WebDriverWait(IosDriverConfig.getDriver(),5);
            try{
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
            }catch (Exception e){
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(AndroidDriverConfig.getDriver(),5);
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
            }catch (Exception e){
            }
        }
    }

    protected void waitForElement(WebElement webElement, Integer timeInSeconds){
        if ("ios".equals(System.getProperty("platform"))){
            WebDriverWait w=new WebDriverWait(IosDriverConfig.getDriver(),timeInSeconds);
            try{
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
            }catch (Exception e){
            }

        }else if ("android".equals(System.getProperty("platform"))){
            try{
                WebDriverWait w=new WebDriverWait(AndroidDriverConfig.getDriver(),timeInSeconds);
                w.until(ExpectedConditions.visibilityOfAllElements(webElement));
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
}
