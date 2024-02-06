package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.GlobalLiveCryptocurrencyChartsFlow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class GlobalLiveCryptocurrencyChartsStep {

  private GlobalLiveCryptocurrencyChartsFlow globalLiveCryptocurrencyChartsFlow;

  public GlobalLiveCryptocurrencyChartsStep() {
    globalLiveCryptocurrencyChartsFlow = new GlobalLiveCryptocurrencyChartsFlow();
  }

  @Then("^the user able to see Global Live Cryptocurrency Charts screen$")
  public void isGlobalLiveCryptocurrencyChartsDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to Global Live Cryptocurrency Charts screen";
    boolean actual = globalLiveCryptocurrencyChartsFlow.isGlobalLiveCryptocurrencyChartsDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }

  @When(
      "^the user click (Market cap|Volume|Bitcoin dominance) 1d button on Global Live Cryptocurrency Charts screen$")
  public void clickOneDayButton(String btnName) throws IllegalAccessException {
    switch (btnName) {
      case "Market cap":
        globalLiveCryptocurrencyChartsFlow.clickMarketCapOneDayButton();
        break;
      case "Volume":
        globalLiveCryptocurrencyChartsFlow.clickVolumeOneDayButton();
        break;
      case "Bitcoin dominance":
        globalLiveCryptocurrencyChartsFlow.clickBitcoinDominanceOneDayButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }

  @Then(
      "^the user verify (Market cap|Volume|Bitcoin dominance) the 1D icon appears the same as the response$")
  public void verifyOneDayResponse(String item)
      throws IOException, IllegalAccessException, ParseException, AWTException {
    boolean expected = true;
    String msg = "The displayed content is inconsistent with the API response";
    boolean actual;

    switch (item) {
      case "Market cap":
        actual = globalLiveCryptocurrencyChartsFlow.verifyMarketCapOneDayResponse();
        break;
      case "Volume":
        actual = globalLiveCryptocurrencyChartsFlow.verifyVolumeOneDayResponse();
        break;
      case "Bitcoin dominance":
        actual = globalLiveCryptocurrencyChartsFlow.verifyBitcoinDominanceOneDayResponse();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", item));
    }
    Assert.assertEquals(msg, expected, actual);
  }
}
