package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.CryptocurrenciesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class CryptocurrenciesFlow extends BaseFlow {

  private CryptocurrenciesPage cryptocurrenciesPage;
  private WebDriver webDriver;

  public CryptocurrenciesFlow() {
    cryptocurrenciesPage = new CryptocurrenciesPage();
    webDriver = WebDriverConfig.getDriver();
  }

  public boolean isCoinmarketcapScreenDisplayed() {
    return checkForElement(cryptocurrenciesPage.coinmarketcapTitle);
  }

  public int swipeDownGetAllCurrencyListSize() {
    waitForElements(cryptocurrenciesPage.currencyNameList);
    swipeToBottom();
    List<WebElement> currencyNameList = cryptocurrenciesPage.currencyNameList;
    List<String> allCurrencyName = new ArrayList<>();
    for (WebElement webElement : currencyNameList) {
      allCurrencyName.add(webElement.getText());
    }
    System.out.println("All currency list : " + allCurrencyName);
    return currencyNameList.size();
  }

  public void clickBackToTopButton() {
    waitForElement(cryptocurrenciesPage.backToTopButton).click();
  }

  public void clickSearchBar() {
    waitForElement(cryptocurrenciesPage.searchBar).click();
  }

  public void selectFirstSearchResult() {
    waitForSeconds(5);
    waitForElement(cryptocurrenciesPage.searchResultList).click();
  }

  public void inputSearchInputBar(String data) {
    waitForElement(cryptocurrenciesPage.searchInputBar).sendKeys(data);
  }

  public void clickExchangeButton() {
    waitForElement(cryptocurrenciesPage.exchangeButton).click();
  }

  public boolean isTopCryptocurrencySpotExchangesScreenDisplayed() {
    return checkForElement(cryptocurrenciesPage.topCryptocurrencySpotExchangesTitle);
  }

  public void selectSpotExchange(String spotExchangeName) {
    findByText(spotExchangeName).click();
  }

  public void clickFearAndGreedIndexChat() {
    waitForElement(cryptocurrenciesPage.fearAndGreedIndexChat).click();
  }

  public void clickAcceptCookieButton(){
    if (checkForElement(cryptocurrenciesPage.acceptCookieButton,30)){
      cryptocurrenciesPage.acceptCookieButton.click();
    }
  }
}
