package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.ConnectWalletPartialModalPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ConnectWalletPartialModalFlow extends BaseFlow {

    private ConnectWalletPartialModalPage connectWalletPartialModalPage;
    private WebDriver webDriver;

    public ConnectWalletPartialModalFlow(){
        connectWalletPartialModalPage = new ConnectWalletPartialModalPage();
        webDriver = WebDriverConfig.getDriver();
    }

    public boolean isConnectWalletPartialModalDisplayed(){
        return checkForElement(connectWalletPartialModalPage.connectWalletPartialModalTitle);
    }

    public void clickButtonByText(String text){
        findByText(text).click();
    }

    public void clickGetWalletButton(){
        waitForElement(connectWalletPartialModalPage.getWallectButton).click();
    }

    public void clickGETButton(){
        waitForElement(connectWalletPartialModalPage.GETButton).click();
    }

    public void clickAddToChromeButton(){
        waitForElement(connectWalletPartialModalPage.addToChromeButton).click();
    }

    public boolean isChromeStoreScreenDisplay(){
        return checkForElement(connectWalletPartialModalPage.connectWalletPartialModalTitle);
    }

    public void clickMetamaskIoLink() {
        switchToLastWindow();
       waitForElement(connectWalletPartialModalPage.metamaskIoLink).click();
    }

    public void clickGotItButton(){
        waitForElement(connectWalletPartialModalPage.gotItButton).click();
    }

    public void clickMetaMaskButton(){
        waitForElement(connectWalletPartialModalPage.metaMaskButton).click();
    }
}
