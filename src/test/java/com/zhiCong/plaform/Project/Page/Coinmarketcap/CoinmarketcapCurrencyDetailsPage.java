package com.zhiCong.Plaform.Project.Page.Coinmarketcap;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CoinmarketcapCurrencyDetailsPage {

  private WebDriver webDriver;

  public CoinmarketcapCurrencyDetailsPage() {
    WebDriverConfig.getInstance();
    webDriver = WebDriverConfig.getDriver();
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(id = "section-coin-overview")
  public WebElement coinmarketcapCurrencyDetailsTitle;

  @FindBy(xpath = "(//div[@class = 'readmoreDesc'])[1]")
  public WebElement loomNetWorkAboutCopy;

  @FindBy(xpath = "(//div[@data-module-name = 'Coin-stats']//button)[1]")
  public WebElement followButton;

  @FindBy(xpath = "//span[@class = 'watchlist-star-text']")
  public WebElement watchlistButton;

  @FindBy(xpath = "//span[@data-title = 'Chart']")
  public WebElement chartButton;

  @FindBy(xpath = "//span[@data-title = 'Markets']")
  public WebElement marketsButton;

  @FindBy(xpath = "//span[@data-title = 'About']")
  public WebElement aboutButton;

  @FindBy(xpath = "//span[contains(text(),'Show rows')]/../div[1]")
  public WebElement rowsDropDown;

  @FindBy(xpath = "//div[contains(@class, 'showInDesktop')]//img[contains(@src, 'metamask')]")
  public WebElement metamaskIcon;

  @FindBy(xpath = "//button[text()= '10' and contains(@class, 'dropdown-item')]")
  public WebElement tenRows;

  @FindBy(xpath = "//button[text()= '20' and contains(@class, 'dropdown-item')]")
  public WebElement twentyRows;

  @FindBy(xpath = "//button[text()= '50' and contains(@class, 'dropdown-item')]")
  public WebElement fiftyRows;

  @FindBy(xpath = "//button[text()= '100' and contains(@class, 'dropdown-item')]")
  public WebElement oneHundredRows;

  @FindBy(
      xpath =
          "(//dl[contains(@class, 'coin-metrics-table')]//div[contains(@class, 'flexBetween')]/dd[contains(@class, 'base-text')])[2]")
  public WebElement totalVolume;

  @FindBy(
      xpath =
          "//table[contains(@class, 'cmc-table')]//div[contains(@class, 'hide-ranking-number')]/p")
  public List<WebElement> marketsName;

  @FindBy(
      xpath = "//table[contains(@class, 'cmc-table')]//tr/td[@style = 'text-align: end;'][4]/span")
  public List<WebElement> marketsVolume;

  @FindBy(
      xpath = "//table[contains(@class, 'cmc-table')]//tr/td[@style = 'text-align: end;'][5]/span")
  public List<WebElement> marketsVolumePercentage;

  @FindBy(xpath = "//table[contains(@class, 'cmc-table')]//span[text()= '-']")
  public WebElement invalidSequence;

  // *[@class = 'highcharts-plot-background']
  @FindBy(xpath = "//*[@id= 'section-coin-chart']")
  public WebElement chartView;

  @FindBy(
      xpath =
          "//*[@id= 'section-coin-chart']//*[contains(@class, 'tooltip')]//span[contains(text(),'/')]")
  public WebElement chartPartialModelDate;

  @FindBy(
      xpath =
          "//*[@id= 'section-coin-chart']//*[contains(@class, 'tooltip')]//span[contains(text(),':00')]")
  public WebElement chartPartialModelTime;

  @FindBy(
      xpath =
          "//*[@id= 'section-coin-chart']//*[contains(@class, 'tooltip')]//span[contains(text(),'Price:')]/..//span[contains(text(),'$')]")
  public WebElement chartPartialModelPrice;

  @FindBy(
      xpath =
          "//*[@id= 'section-coin-chart']//*[contains(@class, 'tooltip')]//span[contains(text(),'Vol 24h:')]/..//span[contains(text(),'$')]")
  public WebElement chartPartialModelVol;
}
