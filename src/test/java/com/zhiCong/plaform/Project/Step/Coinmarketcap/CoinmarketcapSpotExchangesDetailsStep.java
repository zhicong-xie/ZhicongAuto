package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.CoinmarketcapSpotExchangesDetailsFlow;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CoinmarketcapSpotExchangesDetailsStep {

    private CoinmarketcapSpotExchangesDetailsFlow coinmarketcapSpotExchangesDetailsFlow;

    public CoinmarketcapSpotExchangesDetailsStep() {
        coinmarketcapSpotExchangesDetailsFlow = new CoinmarketcapSpotExchangesDetailsFlow();
    }

    @Then("^the user able to see Binance Spot Exchanges details screen$")
    public void isBinanceSpotExchangesDetailsScreenDisplayed() {
        boolean expected = true;
        String msg = "the user can not direct to Binance Spot Exchanges details screen";
        boolean actual = coinmarketcapSpotExchangesDetailsFlow.isBinanceSpotExchangesDetailsScreenDisplayed();
        Assert.assertEquals(msg, expected, actual);
    }

    @Then("^the user check Binance Exchange Proportion on Binance Spot Exchanges details screen$")
    public void isBinanceExchangeProportionPrecise() {
        boolean expected = true;
        String msg = "The Binance Exchange proportion is not precise";
        boolean actual = coinmarketcapSpotExchangesDetailsFlow.isBinanceExchangeProportionPrecise();
        Assert.assertEquals(msg, expected, actual);
    }
}
