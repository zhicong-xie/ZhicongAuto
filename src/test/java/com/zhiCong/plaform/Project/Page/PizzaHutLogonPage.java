package com.zhiCong.Plaform.Project.Page;

import com.zhiCong.Plaform.Base.Config.DriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PizzaHutLogonPage {

    private AppiumDriver appiumDriver;
    private DriverConfig driverConfig;

    public PizzaHutLogonPage(){
        driverConfig = DriverConfig.getInstance();
        appiumDriver = DriverConfig.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @iOSFindBy(id = "Allow")
    public WebElement iosAllowButton;

    @AndroidFindBy(id = "hk_btn")
    @iOSFindBy(id = "splash btn hk en")
    public WebElement hkButton;

    @AndroidFindBy(id = "btnAlertPositive")
    public WebElement tipsConfirmButton;

    @AndroidFindBy(id = "btnSkip")
    @iOSFindBy(id = "Skip")
    public WebElement skipButton;

    @AndroidFindBy(id = "btnStart")
    public WebElement aosStartButton;

    @AndroidFindBy(id = "imgMenu")
    @iOSFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeButton")
    public WebElement menuButton;

    @AndroidFindBy(id = "imgProfile")
    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement profileButton;

    @AndroidFindBy(id = "txtAccountName")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    public WebElement usernameInputBox;

    @AndroidFindBy(id = "txtPw")
    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public WebElement passwordInputBox;

    @AndroidFindBy(id = "btnLogin")
    @iOSFindBy(id = "general btn alert confirm en")
    public WebElement confirmButton;

    @AndroidFindBy(id = "imgMenuItem")
    @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    public WebElement homeButton;

    @iOSFindBy(className = "XCUIElementTypeButton")
    public WebElement apiConfirmButton;

}
