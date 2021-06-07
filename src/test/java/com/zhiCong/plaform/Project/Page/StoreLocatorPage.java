package com.zhiCong.Plaform.Project.Page;

import com.zhiCong.Plaform.Base.Config.DriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoreLocatorPage {

    private AppiumDriver appiumDriver;
    private DriverConfig driverConfig;

    public StoreLocatorPage(){
        driverConfig = DriverConfig.getInstance();
        appiumDriver = DriverConfig.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
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
