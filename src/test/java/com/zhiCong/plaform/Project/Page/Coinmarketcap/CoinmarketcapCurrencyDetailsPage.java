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
}
