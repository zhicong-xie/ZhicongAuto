package com.zhiCong.Plaform.Project.Step;

import com.zhiCong.Plaform.Project.Flow.CryptocurrenciesFlow;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
        System.out.println("the user direct to Coinmarketcap screen");
        String msg = "the user can not direct to Coinmarketcap screen";
        boolean actual = cryptocurrenciesFlow.isCoinmarketcapScreenDisplayed();
        Assert.assertEquals(msg, true, actual);
    }
}
