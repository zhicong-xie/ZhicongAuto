package com.zhiCong.Plaform.Project.Step;

import com.zhiCong.Plaform.Project.Flow.CryptocurrenciesFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CryptocurrenciesStep {

    private CryptocurrenciesFlow cryptocurrenciesFlow;

    public CryptocurrenciesStep(){
        cryptocurrenciesFlow = new CryptocurrenciesFlow();
    }


    @Given("^the user open \"([^\"]*)\" url on Google Chrome$")
    public void openUrlOnGoogleChrome(String url) {
        cryptocurrenciesFlow.openUrlOnGoogleChrome(url);
    }

    @Then("^the user able to see Coinmarketcap screen$")
    public void isCoinmarketcapScreenDisplayed() {
        boolean expected = true;
        String msg = "the user can not direct to Coinmarketcap screen";
        boolean actual = cryptocurrenciesFlow.isCoinmarketcapScreenDisplayed();
        Assert.assertEquals(msg, expected, actual);
    }

    @Then("^the user swipe to down get currency list size is (\\d+) on Coinmarketcap screen$")
    public void swipeDownGetCurrencyListSize(int expected) {
        System.out.println("Get the currency list ...");
        String msg = String.format("The currency list size not is %d",expected);
        int actual = cryptocurrenciesFlow.swipeDownGetAllCurrencyListSize();
        Assert.assertEquals(msg, expected, actual);
    }

    @When("^the user click (Back to top button|Search bar) on Coinmarketcap screen$")
    public void clickBackToTopButton(String btnName) {
        switch (btnName){
            case "Back to top button":
                cryptocurrenciesFlow.clickBackToTopButton();
                break;
            case "Search bar":
                cryptocurrenciesFlow.clickSearchBar();
                break;
        }

    }


    @When("^the user select \"([^\"]*)\" currency on Coinmarketcap screen$")
    public void selectCurrency(String currency) {
        cryptocurrenciesFlow.selectCurrency(currency);
    }

    @When("^the user quit app$")
    public void quitApp() {
        cryptocurrenciesFlow.quitApp();
    }

    @Then("^the user able to see Coinmarketcap currency details screen$")
    public void isCurrencyDetailsScreenDisplayed() {
        boolean expected = true;
        String msg = "the user can not direct to Coinmarketcap currency details screen";
        boolean actual = cryptocurrenciesFlow.isCurrencyDetailsScreenDisplayed();
        Assert.assertEquals(msg, expected, actual);
    }

    @When("^the user Maximize window$")
    public void maximizeWindow() {
        cryptocurrenciesFlow.maximizeWindow();
    }

    @When("^the user input \"([^\"]*)\" in Search input bar on Coinmarketcap screen$")
    public void inputSearchInputBar(String data){
        cryptocurrenciesFlow.inputSearchInputBar(data);
    }
}
