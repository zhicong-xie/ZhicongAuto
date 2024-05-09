package com.zhiCong.Plaform.Project.Step.Coinmarketcap;

import com.zhiCong.Plaform.Project.Flow.Coinmarketcap.CryptocurrenciesFlow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CryptocurrenciesStep {

  private CryptocurrenciesFlow cryptocurrenciesFlow;

  public CryptocurrenciesStep() {
    cryptocurrenciesFlow = new CryptocurrenciesFlow();
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
    String msg = String.format("The currency list size not is %d", expected);
    int actual = cryptocurrenciesFlow.swipeDownGetAllCurrencyListSize();
    Assert.assertEquals(msg, expected, actual);
  }

  @When(
      "^the user click (Back to top button|Search bar|Exchange button|Fear and Greed Index chat) on Coinmarketcap screen$")
  public void clickButton(String btnName) throws IllegalAccessException {
    switch (btnName) {
      case "Back to top button":
        cryptocurrenciesFlow.clickBackToTopButton();
        break;
      case "Search bar":
        cryptocurrenciesFlow.clickSearchBar();
        break;
      case "Exchange button":
        cryptocurrenciesFlow.clickExchangeButton();
        break;
      case "Fear and Greed Index chat":
        cryptocurrenciesFlow.clickFearAndGreedIndexChat();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }

  @When("^the user select first search result on Coinmarketcap screen$")
  public void selectFirstSearchResult() {
    cryptocurrenciesFlow.selectFirstSearchResult();
  }

  @When("^the user input \"([^\"]*)\" in Search input bar on Coinmarketcap screen$")
  public void inputSearchInputBar(String data) {
    cryptocurrenciesFlow.inputSearchInputBar(data);
  }

  @Then("^the user able to see Top Cryptocurrency Spot Exchanges screen$")
  public void isTopCryptocurrencySpotExchangesScreenDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to Top Cryptocurrency Spot Exchanges screen";
    boolean actual = cryptocurrenciesFlow.isTopCryptocurrencySpotExchangesScreenDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user select \"([^\"]*)\" spot exchange on Top Cryptocurrency Spot Exchanges screen$")
  public void selectSpotExchange(String spotExchangeName) {
    cryptocurrenciesFlow.selectSpotExchange(spotExchangeName);
  }

  @When("^the user click Accept Cookies & Continue on Coinmarketcap screen if exists$")
  public void clickAcceptCookieButton() {
    cryptocurrenciesFlow.clickAcceptCookieButton();
  }
}
