package com.zhiCong.plaform.project.Flow;

import com.zhiCong.plaform.project.Page.PizzaHutLogonPage;

import java.util.Map;

public class PizzaHutLogonFlow {

    private PizzaHutLogonPage pizzaHutLogonPage;

    public PizzaHutLogonFlow(){
        pizzaHutLogonPage = new PizzaHutLogonPage();
    }

    public void onLoginScreen(){
        if ("ios".equals(System.getProperty("platform"))){
            pizzaHutLogonPage.iosAllowButton.click();
        }
        sleep(500L);
        pizzaHutLogonPage.hkButton.click();
        sleep(5000L);
        pizzaHutLogonPage.skipButton.click();
        sleep(500L);
        if ("android".equals(System.getProperty("platform"))){
            pizzaHutLogonPage.aosStartButton.click();
        }
        sleep(500L);
        pizzaHutLogonPage.menuButton.click();
        pizzaHutLogonPage.profileButton.click();
        sleep(500L);

    }

    public void inputLogonInformation(Map<String,String> logonInformation){
        pizzaHutLogonPage.usernameInputBox.sendKeys(logonInformation.get("username"));
        pizzaHutLogonPage.passwordInputBox.sendKeys(logonInformation.get("password"));
    }

    public void clickConfirmButton(){
        pizzaHutLogonPage.confirmButton.click();
        sleep(5000L);
    }

    public boolean homeScreenDisplayed(){
        try {
            return pizzaHutLogonPage.menuButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void sleep(Long ms){
        try{
            Thread.sleep(ms);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
