package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Base.LocaleCSVParser;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.CoinmarketcapCurrencyDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoinmarketcapCurrencyDetailsFlow extends BaseFlow {

    private CoinmarketcapCurrencyDetailsPage coinmarketcapCurrencyDetailsPage;
    private WebDriver webDriver;

    public CoinmarketcapCurrencyDetailsFlow() {
        coinmarketcapCurrencyDetailsPage = new CoinmarketcapCurrencyDetailsPage();
        webDriver = WebDriverConfig.getDriver();
    }


    public boolean isCurrencyDetailsScreenDisplayed() {
        return checkForElement(coinmarketcapCurrencyDetailsPage.coinmarketcapCurrencyDetailsTitle);
    }

    public boolean checkLoomNetWorkCopy() {
        swipeToDownFindElement(coinmarketcapCurrencyDetailsPage.loomNetWorkTitle);
        String loomNetworkTitle =
                waitForElement(coinmarketcapCurrencyDetailsPage.loomNetWorkTitle).getText().trim();
        String loomNetWorkDescription = "";
        for (WebElement webElement : coinmarketcapCurrencyDetailsPage.loomNetWorkDescriptionList) {
            loomNetWorkDescription = loomNetWorkDescription + webElement.getText().trim();
        }
        System.out.println("actual copy title" + loomNetworkTitle);
        System.out.println("actual copy description" + loomNetWorkDescription);

        return LocaleCSVParser.getLocaleValue("About_LOOM_Network_title").equals(loomNetworkTitle)
                && LocaleCSVParser.getLocaleValue("About_LOOM_Network_description")
                .equals(loomNetWorkDescription);
    }


    public void clickFollowButton(){
        waitForElement(coinmarketcapCurrencyDetailsPage.followButton).click();
    }

    public void clickWatchlistButton(){
        waitForElement(coinmarketcapCurrencyDetailsPage.watchlistButton).click();
    }

}
