package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.GlobalLiveCryptocurrencyChartsPage;
import org.openqa.selenium.WebDriver;

public class GlobalLiveCryptocurrencyChartsFlow extends BaseFlow {

  private GlobalLiveCryptocurrencyChartsPage globalLiveCryptocurrencyChartsPage;
  private WebDriver webDriver;

  public GlobalLiveCryptocurrencyChartsFlow() {
    globalLiveCryptocurrencyChartsPage = new GlobalLiveCryptocurrencyChartsPage();
    webDriver = WebDriverConfig.getDriver();
  }

  public boolean isGlobalLiveCryptocurrencyChartsDisplayed() {
    return checkForElement(globalLiveCryptocurrencyChartsPage.globalLiveCryptocurrencyChartsTitle);
  }
}
