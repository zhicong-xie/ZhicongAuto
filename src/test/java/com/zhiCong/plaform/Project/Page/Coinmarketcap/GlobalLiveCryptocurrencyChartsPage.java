package com.zhiCong.Plaform.Project.Page.Coinmarketcap;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalLiveCryptocurrencyChartsPage  {

    private WebDriver webDriver;

    public GlobalLiveCryptocurrencyChartsPage() {
        WebDriverConfig.getInstance();
        webDriver = WebDriverConfig.getDriver();
        PageFactory.initElements(webDriver, this);
    }

  @FindBy(xpath = "//h1[@class = 'sc-f70bb44c-0 ezKcbd SummaryHeader_main-title__Y_W3w']")
  public WebElement globalLiveCryptocurrencyChartsTitle;
}
