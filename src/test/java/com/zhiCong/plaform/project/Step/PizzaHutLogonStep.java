package com.zhiCong.plaform.project.Step;

import com.zhiCong.plaform.project.Flow.PizzaHutLogonFlow;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class PizzaHutLogonStep {

    private PizzaHutLogonFlow pizzaHutLogonFlow;

    public PizzaHutLogonStep(){

        pizzaHutLogonFlow = new PizzaHutLogonFlow();
    }

    @Given("^the user on the login screen$")
    public void onLoginScreen(){

        System.out.println("the user go to login screen");
        pizzaHutLogonFlow.onLoginScreen();
    }

    @When("^the user input logon information on the logon screen$")
    public void inputLogonInformation(Map<String,String> logonInformation) {

        System.out.println("the user input logon information");
        pizzaHutLogonFlow.inputLogonInformation(logonInformation);
    }

    @And("^the user click the Confirm button on the login screen$")
    public void clickConfirmButton() {

        System.out.println("the user click confirm button");
        pizzaHutLogonFlow.clickConfirmButton();
    }

    @Then("^the user able to direct the Home screen$")
    public void directHomeScreen() {

        System.out.println("the user direct to home screen");
        String msg = "the user can not direct to home screen";
        boolean expected = pizzaHutLogonFlow.homeScreenDisplayed();
        Assert.assertEquals(msg,true,expected);
    }
}
