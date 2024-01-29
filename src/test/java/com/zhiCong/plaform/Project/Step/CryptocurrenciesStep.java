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

  public CryptocurrenciesStep() {
    cryptocurrenciesFlow = new CryptocurrenciesFlow();
  }

  @Given("^the user open \"([^\"]*)\" url on Google Chrome$")
  public void openUrlOnGoogleChrome(String url) {
    cryptocurrenciesFlow.openUrlOnGoogleChrome(url);
  }

  @Then("^the Browser is opening \"([^\"]*)\" url on Google Chrome$")
  public void isBrowserOpenUrl(String expected) {
    String msg = String.format("The Browser is not opening this %s url", expected);
    String actual = cryptocurrenciesFlow.getBrowserOpenUrl();
    Assert.assertEquals(msg, expected, actual);
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

  @When("^the user click (Back to top button|Search bar|Exchange button) on Coinmarketcap screen$")
  public void clickBackToTopButton(String btnName) throws IllegalAccessException {
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
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }

  @When("^the user select first search result on Coinmarketcap screen$")
  public void selectFirstSearchResult() {
    cryptocurrenciesFlow.selectFirstSearchResult();
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

  @Then("^the user able to see About LOOM NetWork copy on Coinmarketcap currency details screen$")
  public void checkLoomNetWorkCopy() {
    boolean expected = true;
    String msg = "the About LOOM NetWork copy is displayed incorrect";
    boolean actual = cryptocurrenciesFlow.checkLoomNetWorkCopy();
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user Maximize window$")
  public void maximizeWindow() {
    cryptocurrenciesFlow.maximizeWindow();
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

  @Then("^the user able to see Binance Spot Exchanges details screen$")
  public void isBinanceSpotExchangesDetailsScreenDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to Binance Spot Exchanges details screen";
    boolean actual = cryptocurrenciesFlow.isBinanceSpotExchangesDetailsScreenDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }

  @Then("^the user check Binance Exchange Proportion on Binance Spot Exchanges details screen$")
  public void isBinanceExchangeProportionPrecise() {
    boolean expected = true;
    String msg = "The Binance Exchange proportion is not precise";
    boolean actual = cryptocurrenciesFlow.isBinanceExchangeProportionPrecise();
    Assert.assertEquals(msg, expected, actual);
  }
}
