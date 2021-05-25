package com.zhiCong.plaform.project.Flow;


import com.zhiCong.plaform.base.BaseFlow;
import com.zhiCong.plaform.project.Page.PizzaHutLogonPage;
import com.zhiCong.plaform.project.Page.StoreLocatorPage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StoreLocatorFlow extends BaseFlow {

    private StoreLocatorPage storeLocatorPage;
    private PizzaHutLogonPage pizzaHutLogonPage;

    public StoreLocatorFlow(){
        storeLocatorPage = new StoreLocatorPage();
        pizzaHutLogonPage = new PizzaHutLogonPage();
    }


    public void clickStoreLocatorButton(){
        waitForElement(storeLocatorPage.storeLocatorButton,50);
        storeLocatorPage.storeLocatorButton.click();
    }

    public boolean swipeUpFindStore(String storeName){
        List<String> storeNameList = new ArrayList<String>();
        waitForElements(storeLocatorPage.storeName);
        String lastStoreName = "";
        int count = 0;
        while (true){
            for (WebElement webElement : storeLocatorPage.storeName){
                if (!storeNameList.contains(webElement.getText().trim())){
                    storeNameList.add(webElement.getText().trim());
                }
            }
            if (count!=0){
                if (lastStoreName.equals(storeNameList.get(storeNameList.size()-1))){
                    System.out.println("All store name : "+storeNameList);
                    break;
                }
            }
            count++;
            lastStoreName = storeLocatorPage.storeName.get(storeLocatorPage.storeName.size()-1).getText().trim();
            swipeUp();
        }
        return storeNameList.contains(storeName);
    }

    public void toHomeScreen(){
        waitForElement(pizzaHutLogonPage.menuButton);
        storeLocatorPage.menuButton.click();
        pizzaHutLogonPage.homeButton.click();
    }



}
