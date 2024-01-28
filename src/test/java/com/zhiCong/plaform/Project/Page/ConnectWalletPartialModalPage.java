package com.zhiCong.Plaform.Project.Page;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectWalletPartialModalPage {

    private WebDriver webDriver;

    public ConnectWalletPartialModalPage(){
        WebDriverConfig.getInstance();
        webDriver  = WebDriverConfig.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h1[@class = 'iekbcc0 ju367vgo ju367v11 ju367v16 ju367v1d ju367v2q']")
    public WebElement connectWalletPartialModalTitle;

    @FindBy(xpath = "//button[@class = 'iekbcc0 iekbcc9 ju367v72 ju367v7n ju367v83 ju367v6c ju367vc0 ju367vt ju367vv ju367vm ju367v8 ju367v2p ju367v8p ju367v9c ju367v26 _12cbo8i3 ju367v8m _12cbo8i4 _12cbo8i7']")
    public WebElement getWallectButton;

    @FindBy(xpath = "//button[@class = 'iekbcc0 iekbcc9 ju367v72 ju367v7n ju367v83 ju367v6c ju367vc0 ju367vt ju367vv ju367vm ju367v8 ju367v2p ju367v8p ju367v9o ju367v26 _12cbo8i3 ju367v8m _12cbo8i4 _12cbo8i7']")
    public WebElement GETButton;

    @FindBy(xpath = "//a[@class = 'iekbcc0 iekbcca ju367v72 ju367v7n ju367v83 ju367v6c ju367vc0 ju367vt ju367vv ju367vm ju367v8 ju367v2p ju367v8p ju367v9c ju367v26 _12cbo8i3 ju367v8m _12cbo8i4 _12cbo8i7']")
    public WebElement addToChromeButton;

    @FindBy(xpath = "//div[@class = 'QrPGR']")
    public WebElement chromeStoreTitle;

    @FindBy(linkText = "metamask.io")
    public WebElement metamaskIoLink;

    @FindBy(xpath = "//button[@class = 'UywwFc-LgbsSe UywwFc-LgbsSe-OWXEXe-dgl2Hf uhELY']")
    public WebElement gotItButton;

    @FindBy(xpath = "//button[@class = 'iekbcc0 iekbcc9 ju367v84 ju367v6d ju367v6y ju367v7j ju367vo ju367vt ju367vv ju367v8o ju367v99 ju367vav g5kl0l0 _12cbo8i3 ju367v8m _12cbo8i6']")
    public WebElement metaMaskButton;

}
