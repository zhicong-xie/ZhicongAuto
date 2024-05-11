package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.CoinmarketcapCurrencyDetailsFlow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;

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

  @Then(
      "^the user able to see About LOOM NetWork copy \"([^\"]*)\" on Coinmarketcap currency details screen$")
  public void checkLoomNetWorkCopy(String expected) {
    String actual = coinmarketcapCurrencyDetailsFlow.getLoomNetWorkCopy();
    String msg =
        String.format(
            "the About LOOM NetWork expected copy is %s, but LOOM NetWork actual copy is %s",
            expected, actual);
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

  @When(
      "^the user click (Chart|Markets|About) button on Coinmarketcap currency details screen top banner$")
  public void clickTopButton(String btnName) throws IllegalAccessException {
    switch (btnName) {
      case "Chart":
        coinmarketcapCurrencyDetailsFlow.clickChartButton();
        break;
      case "Markets":
        coinmarketcapCurrencyDetailsFlow.clickMarketsButton();
        break;
      case "About":
        coinmarketcapCurrencyDetailsFlow.clickAboutButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }

  @When(
      "^the user select \"([^\"]*)\" rows on Coinmarketcap currency details screen rows dropDown$")
  public void selectRows(String item) throws IllegalAccessException {
    coinmarketcapCurrencyDetailsFlow.selectShowRows(item);
  }

  @When(
      "^the user select Metamask icon on Coinmarketcap currency details screen support wallets view$")
  public void selectMetamaskIcon() {
    coinmarketcapCurrencyDetailsFlow.selectMetamaskIcon();
  }

  @Then(
      "^the user able to see \"([^\"]*)\" volume percentage is correct on Coinmarketcap currency details screen$")
  public void isVolumePercentageCorrect(String item) {
    boolean expected = true;
    String msg = String.format("the user can see %s volume percentage is not correct", item);
    boolean actual = coinmarketcapCurrencyDetailsFlow.isVolumePercentageCorrect(item);
    Assert.assertEquals(msg, expected, actual);
  }

  @Then(
      "^the user verify 1D price chart data is align with response on Coinmarketcap currency details screen$")
  public void verifyOneDayChartAlignResponse()
      throws IOException, ParseException, IllegalAccessException {
    boolean expected = true;
    String msg = "1D price chart data is not align with response";
    boolean actual = coinmarketcapCurrencyDetailsFlow.verifyOneDayChartAlignResponse();
    Assert.assertEquals(msg, expected, actual);
  }
}
