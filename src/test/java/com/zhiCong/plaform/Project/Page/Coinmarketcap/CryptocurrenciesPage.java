package com.zhiCong.Plaform.Project.Page.Coinmarketcap;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CryptocurrenciesPage {

  private WebDriver webDriver;

  public CryptocurrenciesPage() {
    WebDriverConfig.getInstance();
    webDriver = WebDriverConfig.getDriver();
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//*[contains(@class, 'cmc-logo tooltip')]")
  public WebElement coinmarketcapTitle;

  @FindBy(
      xpath = "//*[contains(@class, 'cmc-table')]//*[contains(@class, 'hide-ranking-number')]/p")
  public List<WebElement> currencyNameList;

  @FindBy(id = "scroll-to-top")
  public WebElement backToTopButton;

  @FindBy(xpath = "//*[contains(@class, 'search-input-static')]/div[1]")
  public WebElement searchBar;

  @FindBy(xpath = "//input[contains(@class, 'desktop-input')]")
  public WebElement searchInputBar;

  @FindBy(xpath = "//div[contains(text(),'Cryptoassets')]/..//span[contains(@class, 'coin-name')]")
  public WebElement searchResultList;

  @FindBy(id = "onetrust-accept-btn-handler")
  public WebElement acceptCookieButton;
}
