package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.CoinmarketcapWatchlistPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;

public class CoinmarketcapWatchlistFlow extends BaseFlow {

  private CoinmarketcapWatchlistPage coinmarketcapWatchlistPage;
  private WebDriver webDriver;

  public CoinmarketcapWatchlistFlow() {
    coinmarketcapWatchlistPage = new CoinmarketcapWatchlistPage();
    webDriver = WebDriverConfig.getDriver();
  }

  public boolean isWatchlistListScreenDisplayed() {
    return checkForElement(coinmarketcapWatchlistPage.watchlistListTitle);
  }

  public HashMap<String, String> getWatchlistList() {
    HashMap<String, String> watchlist = new HashMap<>();

    // 获取watchlist 列表
    List<WebElement> watchListName = coinmarketcapWatchlistPage.watchlistListName;
    int index = 0;

    for (int i = 0; i < (watchListName.size() + 1) / 2; i++) {

      String fullName = "";
      String abbreviation = "";

      // 存储currency 全称
      if ((index + 1) % 2 != 0) {
        fullName = watchListName.get(index).getText().trim();
        index++;
      }
      // 存储currency 缩写
      if ((index + 1) % 2 == 0) {
        abbreviation = watchListName.get(index).getText().trim();
        index++;
      }
      watchlist.put(fullName, abbreviation);
    }

    System.out.println("Watchlist : " + watchlist);
    return watchlist;
  }
}
