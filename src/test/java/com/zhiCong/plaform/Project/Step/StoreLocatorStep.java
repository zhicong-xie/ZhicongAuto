package com.zhiCong.Plaform.Project.Step;

import com.zhiCong.Plaform.Project.Flow.StoreLocatorFlow;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.concurrent.ExecutionException;

public class StoreLocatorStep {

  private StoreLocatorFlow storeLocatorFlow;

  public StoreLocatorStep() throws ExecutionException, InterruptedException {

    storeLocatorFlow = new StoreLocatorFlow();
  }

  @When("^the user click Store locator button on the Home screen$")
  public void clickStoreLocatorButton() {

    System.out.println("the user click Store locator button");
    storeLocatorFlow.clickStoreLocatorButton();
  }

  @Then("^the user swipe up find \"([^\"]*)\" store on the Store locator screen$")
  public void swipeUpFindStore(String storeName) {

    System.out.println(String.format("the user swipe up find %s store", storeName));
    Assert.assertEquals(
        String.format("the user not find %s store", storeName),
        false,
        storeLocatorFlow.swipeUpFindStore(storeName));
  }

  @And("^the user return to Home screen$")
  public void toHomeScreen() {

    storeLocatorFlow.toHomeScreen();
  }
}
