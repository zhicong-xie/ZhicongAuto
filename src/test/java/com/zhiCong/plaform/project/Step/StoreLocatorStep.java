package com.zhiCong.plaform.project.Step;

import com.zhiCong.plaform.project.Flow.StoreLocatorFlow;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StoreLocatorStep {


    private StoreLocatorFlow storeLocatorFlow;

    public StoreLocatorStep(){

        storeLocatorFlow = new StoreLocatorFlow();
    }

    @When("^the user click Store locator button on the Home screen$")
    public void clickStoreLocatorButton() {

        System.out.println("the user click Store locator button");
        storeLocatorFlow.clickStoreLocatorButton();
    }

    @Then("^the user swipe up find \"([^\"]*)\" store on the Store locator screen$")
    public void swipeUpFindStore(String storeName){

        System.out.println(String.format("the user swipe up find %s store",storeName));
        Assert.assertEquals(String.format("the user not find %s store",storeName),false,storeLocatorFlow.swipeUpFindStore(storeName));
    }

    @And("^the user return to Home screen$")
    public void toHomeScreen() {

        System.out.println("the user click system back button");
        storeLocatorFlow.toHomeScreen();
    }

}
