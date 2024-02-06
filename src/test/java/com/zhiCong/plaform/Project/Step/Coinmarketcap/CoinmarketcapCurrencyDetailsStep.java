package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.CoinmarketcapCurrencyDetailsFlow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CoinmarketcapCurrencyDetailsStep {

  private CoinmarketcapCurrencyDetailsFlow coinmarketcapCurrencyDetailsFlow;

  public CoinmarketcapCurrencyDetailsStep() {
    coinmarketcapCurrencyDetailsFlow = new CoinmarketcapCurrencyDetailsFlow();
  }

  @Then("^the user able to see Coinmarketcap currency details screen$")
  public void isCurrencyDetailsScreenDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to Coinmarketcap currency details screen";
    boolean actual = coinmarketcapCurrencyDetailsFlow.isCurrencyDetailsScreenDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }

  @Then("^the user able to see About LOOM NetWork copy on Coinmarketcap currency details screen$")
  public void checkLoomNetWorkCopy() {
    boolean expected = true;
    String msg = "the About LOOM NetWork copy is displayed incorrect";
    boolean actual = coinmarketcapCurrencyDetailsFlow.checkLoomNetWorkCopy();
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user click (Follow|Watchlist) button on Coinmarketcap currency details screen$")
  public void clickButton(String btn) throws IllegalAccessException {
    switch (btn) {
      case "Follow":
        coinmarketcapCurrencyDetailsFlow.clickFollowButton();
        break;
      case "Watchlist":
        coinmarketcapCurrencyDetailsFlow.clickWatchlistButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btn));
    }
  }
}
