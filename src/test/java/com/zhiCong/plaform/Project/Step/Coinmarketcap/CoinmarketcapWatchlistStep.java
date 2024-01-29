package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.CoinmarketcapWatchlistFlow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;

public class CoinmarketcapWatchlistStep {

    private CoinmarketcapWatchlistFlow coinmarketcapWatchlistFlow;

    public CoinmarketcapWatchlistStep() {
        coinmarketcapWatchlistFlow = new CoinmarketcapWatchlistFlow();
    }


    @Then("^the user able to see Coinmarketcap watchlist screen$")
    public void isWatchlistListScreenDisplayed() {
        boolean expected = true;
        String msg = "the user can not direct to Coinmarketcap watchlist list screen";
        boolean actual = coinmarketcapWatchlistFlow.isWatchlistListScreenDisplayed();
        Assert.assertEquals(msg, expected, actual);
    }

    @Then("^the user able to see \"([^\"]*)\" currency in watchlist on Coinmarketcap watchlist screen$")
    public void isCurrencyDisplayedInWatchlist(String item){
        String msg = String.format("The %s currency is not in watchlist",item);
        boolean expected = true;
        boolean actual = false;
        HashMap<String,String> watchlist = coinmarketcapWatchlistFlow.getWatchlistList();
        if (watchlist.containsKey(item)||watchlist.containsValue(item)){
            actual = true;
        }
        Assert.assertEquals(msg, expected, actual);
    }
}
