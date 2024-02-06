package com.zhiCong.Plaform.Project.Page.Coinmarketcap;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CoinmarketcapSpotExchangesDetailsPage {

  private WebDriver webDriver;

  public CoinmarketcapSpotExchangesDetailsPage() {
    WebDriverConfig.getInstance();
    webDriver = WebDriverConfig.getDriver();
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//h1[@class = 'sc-aba8b85a-0 sc-d36bb8b9-3 dtdOWf']")
  public WebElement binanceSpotExchangesDetailsTitle;

  @FindBy(xpath = "//span[@class = 'sc-4984dd93-0 fREVOF priceText']")
  public WebElement spotExchangesDetailsBalance;

  @FindBy(
      xpath = "//*[contains (@class, 'sc-b27a436d-10 LQXt')]/p[@class = 'sc-4984dd93-0 kKpPOn']")
  public List<WebElement> chartFilterCurrencyButtonList;

  @FindBy(
      xpath = "//*[contains (@class, 'sc-b27a436d-10 LQXt')]/p[@class = 'sc-4984dd93-0 cEFVjA']")
  public List<WebElement> chartFilterProportionList;

  @FindBy(
      xpath =
          "//table[@class = 'sc-feda9013-3 gLzycC cmc-table  ']//td[contains(@style, 'text-align:')]")
  public List<WebElement> refinedBalanceList;

  @FindBy(xpath = "//div[@class = 'sc-b27a436d-8 kbhqyE']//*[contains(text(),'Load More')]/..")
  public WebElement loadingMoreButton;

  @FindBy(id = "onetrust-accept-btn-handler")
  public WebElement acceptCookiesAndContinueButton;

  @FindBy(xpath = "//div[@class = 'sc-4ce79553-0 hHIalA visible']")
  public WebElement backToTopButton;
}
