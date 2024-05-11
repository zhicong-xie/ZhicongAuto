package com.zhiCong.Plaform.Project.Page.Coinmarketcap;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CoinmarketcapWatchlistPage {

  private WebDriver webDriver;

  public CoinmarketcapWatchlistPage() {
    WebDriverConfig.getInstance();
    webDriver = WebDriverConfig.getDriver();
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(xpath = "//h1[contains(text(),'Create Your Crypto Watchlist Today')]")
  public WebElement watchlistListTitle;

  @FindBy(xpath = "//div[@class = 'sc-aef7b723-0 sc-1c5f2868-2 bhBHDD  hide-ranking-number']//p")
  public List<WebElement> watchlistListName;
}
