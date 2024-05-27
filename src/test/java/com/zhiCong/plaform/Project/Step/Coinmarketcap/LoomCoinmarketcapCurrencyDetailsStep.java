package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.LoomCoinmarketcapCurrencyDetailsFlow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;

public class LoomCoinmarketcapCurrencyDetailsStep {

  private LoomCoinmarketcapCurrencyDetailsFlow loomCoinmarketcapCurrencyDetailsFlow;

  public LoomCoinmarketcapCurrencyDetailsStep() {
    loomCoinmarketcapCurrencyDetailsFlow = new LoomCoinmarketcapCurrencyDetailsFlow();
  }

  @Then("^the user able to see LOOM Coinmarketcap currency details screen$")
  public void isCurrencyDetailsScreenDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to LOOM Coinmarketcap currency details screen";
    boolean actual = loomCoinmarketcapCurrencyDetailsFlow.isCurrencyDetailsScreenDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }

  @Then(
      "^the user able to see About LOOM NetWork copy \"([^\"]*)\" on LOOM Coinmarketcap currency details screen$")
  public void checkLoomNetWorkCopy(String expected) {
    String actual = loomCoinmarketcapCurrencyDetailsFlow.getLoomNetWorkCopy();
    String msg =
        String.format(
            "the About LOOM NetWork expected copy is %s, but LOOM NetWork actual copy is %s",
            expected, actual);
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user click (Follow|Watchlist) button on LOOM Coinmarketcap currency details screen$")
  public void clickButton(String btn) throws IllegalAccessException {
    switch (btn) {
      case "Follow":
        loomCoinmarketcapCurrencyDetailsFlow.clickFollowButton();
        break;
      case "Watchlist":
        loomCoinmarketcapCurrencyDetailsFlow.clickWatchlistButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btn));
    }
  }

  @When(
      "^the user click (Chart|Markets|About) button on LOOM Coinmarketcap currency details screen top banner$")
  public void clickTopButton(String btnName) throws IllegalAccessException {
    switch (btnName) {
      case "Chart":
        loomCoinmarketcapCurrencyDetailsFlow.clickChartButton();
        break;
      case "Markets":
        loomCoinmarketcapCurrencyDetailsFlow.clickMarketsButton();
        break;
      case "About":
        loomCoinmarketcapCurrencyDetailsFlow.clickAboutButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }

  @When(
      "^the user select \"([^\"]*)\" rows on LOOM Coinmarketcap currency details screen rows dropDown$")
  public void selectRows(String item) throws IllegalAccessException {
    loomCoinmarketcapCurrencyDetailsFlow.selectShowRows(item);
  }

  @When(
      "^the user select Metamask icon on LOOM Coinmarketcap currency details screen support wallets view$")
  public void selectMetamaskIcon() {
    loomCoinmarketcapCurrencyDetailsFlow.selectMetamaskIcon();
  }

  @Then(
      "^the user able to see \"([^\"]*)\" volume percentage is correct on LOOM Coinmarketcap currency details screen$")
  public void isVolumePercentageCorrect(String item) {
    boolean expected = true;
    String msg = String.format("the user can see %s volume percentage is not correct", item);
    boolean actual = loomCoinmarketcapCurrencyDetailsFlow.isVolumePercentageCorrect(item);
    Assert.assertEquals(msg, expected, actual);
  }

  @Then(
      "^the user verify 1D price chart data is align with response on LOOM Coinmarketcap currency details screen$")
  public void verifyOneDayChartAlignResponse()
      throws IOException, ParseException, IllegalAccessException {
    boolean expected = true;
    String msg = "1D price chart data is not align with response";
    boolean actual = loomCoinmarketcapCurrencyDetailsFlow.verifyOneDayChartAlignResponse();
    Assert.assertEquals(msg, expected, actual);
  }
}
