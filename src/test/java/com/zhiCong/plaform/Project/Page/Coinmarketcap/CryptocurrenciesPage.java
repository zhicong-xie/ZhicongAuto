package com.zhiCong.Plaform.Project.Page.Coinmarketcap;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CryptocurrenciesPage {

  private WebDriver webDriver;

  public CryptocurrenciesPage() {
    WebDriverConfig.getInstance();
    webDriver = WebDriverConfig.getDriver();
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//a[@class = 'sc-f2e7c84b-2 bOPkpb cmc-logo tooltip']")
  public WebElement coinmarketcapTitle;

  @FindBy(id = "drop-anchor")
  public WebElement ReadMoreLink;

  @FindBy(xpath = "//div[@class = 'sc-adbfcfff-3 dDrhas']")
  public List<WebElement> currencyNameList;

  @FindBy(xpath = "//div[@class = 'sc-4ce79553-0 hHIalA visible']")
  public WebElement backToTopButton;

  @FindBy(xpath = "//div[@class = 'sc-e20acb0c-1 fWcxPm']")
  public WebElement searchBar;

  @FindBy(xpath = "//div[@class = 'sc-8829bc3d-6 eHPaKU']/input")
  public WebElement searchInputBar;

  @FindBy(xpath = "//span[@class = 'sc-f70bb44c-0 ipezdW coin-name']")
  public WebElement searchResultList;

  @FindBy(xpath = "//div[@class = 'sc-8b3d12a8-1 hDjzmZ menu-item-1']")
  public WebElement exchangeButton;

  @FindBy(xpath = "//div[@class ='sc-f70bb44c-0 dcmrty']")
  public WebElement topCryptocurrencySpotExchangesTitle;
}
