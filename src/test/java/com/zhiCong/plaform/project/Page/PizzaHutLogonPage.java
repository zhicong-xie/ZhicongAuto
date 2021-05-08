package com.zhiCong.plaform.project.Page;

import com.zhiCong.plaform.base.config.AndroidDriverConfig;
import com.zhiCong.plaform.base.config.IosDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PizzaHutLogonPage {

    private AndroidDriverConfig androidDriverConfig;
    private AndroidDriver androidDriver;
    private IosDriverConfig iosDriverConfig;
    private IOSDriver iosDriver;

    public PizzaHutLogonPage(){
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

    @iOSFindBy(id = "Allow")
    public WebElement iosAllowButton;

    @AndroidFindBy(id = "hk_btn")
    @iOSFindBy(id = "splash btn hk tc")
    public WebElement hkButton;

    @AndroidFindBy(id = "btnSkip")
    @iOSFindBy(id = "略過")
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
    @iOSFindBy(id = "general btn alert confirm tc")
    public WebElement confirmButton;

}
