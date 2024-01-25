package com.zhiCong.Plaform.Project.Page;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YogapetzPage {

    private WebDriver webDriver;

    public YogapetzPage(){
        WebDriverConfig.getInstance();
        webDriver  = WebDriverConfig.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class = 'container relative flex items-center justify-center py-7']")
    public WebElement yogapetzTitle;

    @FindBy(xpath = "//div[@class = 'absolute left-6 top-1/2 -translate-y-1/2 flex items-center justify-center']")
    public WebElement menuButton;

    @FindBy(xpath = "//a[@class = 'flex-shrink-0 ml-auto inline-flex items-center justify-center']")
    public WebElement settingButton;

    @FindBy(xpath = "//h1[@class = 'iekbcc0 ju367vgo ju367v11 ju367v16 ju367v1d ju367v2q']")
    public WebElement connectWalletPartialModalTitle;
}
