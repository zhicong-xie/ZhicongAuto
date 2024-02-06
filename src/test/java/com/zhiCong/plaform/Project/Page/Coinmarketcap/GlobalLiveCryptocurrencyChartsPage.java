package com.zhiCong.Plaform.Project.Page.Coinmarketcap;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class GlobalLiveCryptocurrencyChartsPage {

  private WebDriver webDriver;

  public GlobalLiveCryptocurrencyChartsPage() {
    WebDriverConfig.getInstance();
    webDriver = WebDriverConfig.getDriver();
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//h1[@class = 'sc-f70bb44c-0 ezKcbd SummaryHeader_main-title__Y_W3w']")
  public WebElement globalLiveCryptocurrencyChartsTitle;

  @FindBy(xpath = "//div[@id = 'market-cap']//li")
  public WebElement marketCapOneDayButton;

  @FindBy(xpath = "//div[@id = 'volume-24h']//li")
  public WebElement volumeOneDayButton;

  @FindBy(xpath = "//div[@id = 'bitcoin-dominance']//li")
  public WebElement bitcoinDominanceOneDayButton;

  @FindBy(xpath = "//div[@class = 'sc-4ce79553-0 hHIalA visible']")
  public WebElement backToTopButton;

  @FindBy(xpath = "//div[@id = 'market-cap']//*[@class = 'highcharts-root']")
  public WebElement marketCapChat;

  @FindBy(
      xpath =
          "//div[@id = 'market-cap']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//span[contains(text(),'/')]")
  public WebElement marketCapOneDayTooltipDate;

  @FindBy(
      xpath =
          "//div[@id = 'market-cap']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//span[contains(text(),':00')]")
  public WebElement marketCapOneDayTooltipTime;

  @FindBy(
      xpath =
          "//div[@id = 'market-cap']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//span[contains(text(),'$')]")
  public WebElement marketCapOneDayTooltipAmount;

  @FindBy(xpath = "//div[@id = 'volume-24h']//*[@class = 'highcharts-root']")
  public WebElement volumeChat;

  @FindBy(
      xpath =
          "//div[@id = 'volume-24h']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//span[contains(text(),'/')]")
  public WebElement volumeOneDayTooltipDate;

  @FindBy(
      xpath =
          "//div[@id = 'volume-24h']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//span[contains(text(),':00')]")
  public WebElement volumeOneDayTooltipTime;

  @FindBy(
      xpath =
          "//div[@id = 'volume-24h']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//span[contains(text(),'$')]")
  public WebElement volumeOneDayTooltipAmount;

  @FindBy(xpath = "//div[@id = 'bitcoin-dominance']//*[@class = 'highcharts-root']")
  public WebElement bitcoinDominanceChat;

  @FindBy(
      xpath =
          "//div[@id = 'bitcoin-dominance']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//div[contains(text(),'/')]")
  public WebElement bitcoinDominanceOneDayTooltipDate;

  @FindBy(
      xpath =
          "//div[@id = 'bitcoin-dominance']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//div[contains(text(),':00')]")
  public WebElement bitcoinDominanceOneDayTooltipTime;

  @FindBy(
      xpath =
          "//div[@id = 'bitcoin-dominance']//div[@class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//span")
  public List<WebElement> bitcoinDominanceOneDayTooltipDataList;
}
