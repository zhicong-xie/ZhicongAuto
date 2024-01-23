package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CryptocurrenciesFlow extends BaseFlow {

    private WebDriver webDriver;

    public CryptocurrenciesFlow(){
        WebDriverConfig.getInstance();
        webDriver  = WebDriverConfig.getDriver();
    }



  @FindBy(xpath = "//div[@class='sc-f2e7c84b-2 bOPkpb cmc-logo tooltip']")
  public WebElement coinmarketcapTitle;

    public void openUrlOnGoogleChrome(String url){
        System.out.println(String.format("Opening %s link on Google Chrome",url));
        webDriver.get(url);
    }

    public boolean isCoinmarketcapScreenDisplayed(){
        return checkForElement(webDriver,coinmarketcapTitle);
    }
}
