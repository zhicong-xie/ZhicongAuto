package com.zhiCong.plaform.project.Step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestDemoSteps {

    @Given("^the user on Logon page$")
    public void onLoginPage(){
        System.out.println("the user on Logon page");
    }

    @When("^the user input login information on Logon page$")
    public void inputLoginInformation() {
        System.out.println("the user input login information");
    }

    @And("^the user click Confirm button on the Login page$")
    public void clickConfirmButton() {
        System.out.println("the user click Confirm button");
    }

    @Then("^the user able to see Home page$")
    public void HomePageDisplayed() {
        System.out.println("the user on Home page");
    }

    @When("^the user input (.*) in username input box on Logon page$")
    public void inputUsername(String userName){
        System.out.println(String.format("the user input %s in username input box",userName));
    }

    @When("^the user input (.*) in password input box on Logon page$")
    public void inputPassword(String password){
        System.out.println(String.format("the user input %s in password input box",password));
    }
}
