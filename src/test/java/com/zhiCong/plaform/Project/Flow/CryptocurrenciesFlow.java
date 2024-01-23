package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.CryptocurrenciesPage;
import org.openqa.selenium.WebDriver;

public class CryptocurrenciesFlow extends BaseFlow {

    private CryptocurrenciesPage cryptocurrenciesPage;
    private WebDriver webDriver;

    public CryptocurrenciesFlow(){
        cryptocurrenciesPage = new CryptocurrenciesPage();
        webDriver  = WebDriverConfig.getDriver();
    }

    public void openUrlOnGoogleChrome(String url){
        System.out.println(String.format("Opening %s link on Google Chrome",url));
        webDriver.get(url);
    }

    public boolean isCoinmarketcapScreenDisplayed(){
        return checkForElement(cryptocurrenciesPage.coinmarketcapTitle);
    }

}
