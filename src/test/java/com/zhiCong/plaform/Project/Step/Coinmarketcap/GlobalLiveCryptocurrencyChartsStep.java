package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.GlobalLiveCryptocurrencyChartsFlow;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class GlobalLiveCryptocurrencyChartsStep {

  private GlobalLiveCryptocurrencyChartsFlow globalLiveCryptocurrencyChartsFlow;

  public GlobalLiveCryptocurrencyChartsStep() {
    globalLiveCryptocurrencyChartsFlow = new GlobalLiveCryptocurrencyChartsFlow();
  }

  @Then("^the user able to see Global Live Cryptocurrency Charts screen$")
  public void isGlobalLiveCryptocurrencyChartsDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to Coinmarketcap screen";
    boolean actual = globalLiveCryptocurrencyChartsFlow.isGlobalLiveCryptocurrencyChartsDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }
}
