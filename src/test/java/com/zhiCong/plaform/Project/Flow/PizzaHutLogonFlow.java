package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Project.Page.PizzaHutLogonPage;

import java.util.Map;

public class PizzaHutLogonFlow extends BaseFlow {

    private PizzaHutLogonPage pizzaHutLogonPage;

    public PizzaHutLogonFlow(){
        pizzaHutLogonPage = new PizzaHutLogonPage();
    }

    public void onLoginScreen(){
        if ("ios".equals(System.getProperty("platform"))){
            waitForElement(pizzaHutLogonPage.iosAllowButton);
            pizzaHutLogonPage.iosAllowButton.click();
        }
        waitForElement(pizzaHutLogonPage.hkButton);
        pizzaHutLogonPage.hkButton.click();
        waitForElement(pizzaHutLogonPage.skipButton,15);
        pizzaHutLogonPage.skipButton.click();
        if ("android".equals(System.getProperty("platform"))){
            waitForElement(pizzaHutLogonPage.aosStartButton);
            pizzaHutLogonPage.aosStartButton.click();
        }
        waitForElement(pizzaHutLogonPage.menuButton);
        pizzaHutLogonPage.menuButton.click();
        waitForElement(pizzaHutLogonPage.profileButton);
        pizzaHutLogonPage.profileButton.click();
    }

    public void inputLogonInformation(Map<String,String> logonInformation){
        waitForElement(pizzaHutLogonPage.usernameInputBox);
        pizzaHutLogonPage.usernameInputBox.sendKeys(logonInformation.get("username"));
        pizzaHutLogonPage.passwordInputBox.sendKeys(logonInformation.get("password"));
    }

    public void clickConfirmButton(){
        pizzaHutLogonPage.confirmButton.click();
        if ("ios".equals(System.getProperty("platform"))){
            waitForElement(pizzaHutLogonPage.apiConfirmButton);
            pizzaHutLogonPage.apiConfirmButton.click();
        }
    }

    public boolean homeScreenDisplayed(){
        return checkForElement(pizzaHutLogonPage.menuButton,20);
    }
}
