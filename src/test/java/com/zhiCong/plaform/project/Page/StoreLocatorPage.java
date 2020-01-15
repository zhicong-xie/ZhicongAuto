package com.zhiCong.plaform.project.Page;

import com.zhiCong.plaform.base.config.AndroidDriverConfig;
import com.zhiCong.plaform.base.config.IosDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoreLocatorPage {

    private AndroidDriverConfig androidDriverConfig;
    private AndroidDriver androidDriver;
    private IosDriverConfig iosDriverConfig;
    private IOSDriver iosDriver;

    public StoreLocatorPage(){
        if ("ios".equals(System.getProperty("platform"))){
            iosDriverConfig = IosDriverConfig.getInstance();
            iosDriver = IosDriverConfig.getDriver();
            PageFactory.initElements(new AppiumFieldDecorator(iosDriver), this);
        }else {
            androidDriverConfig = AndroidDriverConfig.getInstance();
            androidDriver = AndroidDriverConfig.getDriver();
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        }
    }


    @AndroidFindBy(id = "imgStore")
    @iOSFindBy(id = "index btn store get ticket en")
    public WebElement storeLocatorButton;


    @AndroidFindBy(id = "txtTitle")
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
    public List<WebElement> storeName;

    @AndroidFindBy(id = "imgABLeftBtn")
    @iOSFindBy(id = "general btn top menu")
    public WebElement menuButton;

}
