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

  @FindBy(xpath = "//div[@class = 'sc-f70bb44c-0 hNnCrE top']")
  public WebElement loomNetWorkTitle;

  @FindBy(xpath = "//div[@class = 'sc-f70bb44c-0 lcMKAk show']//p")
  public List<WebElement> loomNetWorkDescriptionList;

  @FindBy(
      xpath =
          "//button[@class = 'sc-f70bb44c-0 iQEJet BaseButton_base__aMbeB BaseButton_t-default__fZuC3 BaseButton_size-sm__RoliW BaseButton_v-tertiary___qgax BaseButton_vd__2Cn0v BaseButton_only-icon___aRCM']")
  public WebElement followButton;

  @FindBy(xpath = "//span[@class = 'watchlist-star-text']")
  public WebElement watchlistButton;

  @FindBy(xpath = "//span[@data-title = 'Chart']")
  public WebElement chartButton;

  @FindBy(xpath = "//span[@data-title = 'Markets']")
  public WebElement marketsButton;

  @FindBy(xpath = "//span[@data-title = 'About']")
  public WebElement aboutButton;

  @FindBy(xpath = "//div[@class = 'sc-aef7b723-0 sc-df1620aa-1 jKiFcK']/div[@class = 'sc-aef7b723-0 sc-4465b840-0 ebFoZm']")
  public WebElement rowsDropDown;

  @FindBy(xpath = "//div[@class = 'sc-f70bb44c-0 iQEJet icons flexStart showInDesktop']/img[2]")
  public WebElement metamaskIcon;

  @FindBy(xpath = "//button[@class = 'sc-2861d03b-0 gOwguC dropdown-item'][4]")
  public WebElement tenRows;

  @FindBy(xpath = "//button[@class = 'sc-2861d03b-0 gOwguC dropdown-item'][3]")
  public WebElement twentyRows;

  @FindBy(xpath = "//button[@class = 'sc-2861d03b-0 gOwguC dropdown-item'][2]")
  public WebElement fiftyRows;

  @FindBy(xpath = "//button[@class = 'sc-2861d03b-0 gOwguC dropdown-item'][1]")
  public WebElement oneHundredRows;

  @FindBy(xpath = "(//div[@class = 'sc-f70bb44c-0 sc-cd4f73ae-0 iowNqu flexBetween']//dd[@class = 'sc-f70bb44c-0 bCgkcs base-text'])[2]")
  public WebElement totalVolume;

  @FindBy(xpath = "//table//p[@class = 'sc-4984dd93-0 eAGSmT']")
  public List<WebElement> marketsName;

  @FindBy(xpath = "//table//tr/td[@style = 'text-align: end;'][4]/span")
  public List<WebElement> marketsVolume;

  @FindBy(xpath = "//table//tr/td[@style = 'text-align: end;'][5]/span")
  public List<WebElement> marketsVolumePercentage;

  @FindBy(xpath = "//span[@class = 'sc-f70bb44c-0 iQEJet sc-90c5a201-2 MXNho']")
  public WebElement invalidSequence;
}
