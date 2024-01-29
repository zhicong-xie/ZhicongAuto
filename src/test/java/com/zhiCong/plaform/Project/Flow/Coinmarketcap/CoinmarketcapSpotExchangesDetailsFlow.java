package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.CoinmarketcapSpotExchangesDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

public class CoinmarketcapSpotExchangesDetailsFlow extends BaseFlow {

    private CoinmarketcapSpotExchangesDetailsPage coinmarketcapSpotExchangesDetailsPage;
    private WebDriver webDriver;

    public CoinmarketcapSpotExchangesDetailsFlow() {
        coinmarketcapSpotExchangesDetailsPage = new CoinmarketcapSpotExchangesDetailsPage();
        webDriver = WebDriverConfig.getDriver();
    }

    public boolean isBinanceSpotExchangesDetailsScreenDisplayed() {
        return checkForElement(coinmarketcapSpotExchangesDetailsPage.binanceSpotExchangesDetailsTitle);
    }

    public boolean isBinanceExchangeProportionPrecise() {

        BigDecimal totalBalance =
                new BigDecimal(
                        keepNumbersDecimalPoints(
                                waitForElement(coinmarketcapSpotExchangesDetailsPage.spotExchangesDetailsBalance).getText()));
        System.out.println("Binance total balance : " + totalBalance);
        List<WebElement> filerCurrency = coinmarketcapSpotExchangesDetailsPage.chartFilterCurrencyButtonList;
        for (int i = 0; i < filerCurrency.size() - 1; i++) {
            String currencyName = filerCurrency.get(i).getText();

            // 如果Accept Cookies & Continue button 存在则点击
            if (checkForElement(coinmarketcapSpotExchangesDetailsPage.acceptCookiesAndContinueButton, 5)) {
                coinmarketcapSpotExchangesDetailsPage.acceptCookiesAndContinueButton.click();
            }

            // 开始筛选货币列表
            filerCurrency.get(i).click();
            BigDecimal expected =
                    new BigDecimal(
                            keepNumbersDecimalPoints(
                                    coinmarketcapSpotExchangesDetailsPage.chartFilterProportionList.get(i).getText()));

            BigDecimal currentCurrencyAmount = BigDecimal.valueOf(0);

            // 展开该表格的所有数据
            for (int j = 0; j < 3; j++) {
                if (checkForElement(coinmarketcapSpotExchangesDetailsPage.loadingMoreButton, 3)) {
                    coinmarketcapSpotExchangesDetailsPage.loadingMoreButton.click();
                    swipeToDown();
                }
            }

            // 获取该货币的金额
            List<WebElement> currencyAmountList = coinmarketcapSpotExchangesDetailsPage.refinedBalanceList;
            for (int x = 0; x < currencyAmountList.size(); x++) {
                if ((x + 1) % 4 == 0) {
                    BigDecimal amount =
                            new BigDecimal(keepNumbersDecimalPoints(currencyAmountList.get(x).getText()));
                    currentCurrencyAmount = currentCurrencyAmount.add(amount);
                } else {
                    continue;
                }
            }
            System.out.println(
                    String.format("%s currency total balance : %s", currencyName, currentCurrencyAmount));
            BigDecimal actual =
                    (currentCurrencyAmount.multiply(new BigDecimal(100))).divide(totalBalance, 2);
            System.out.println(
                    "Currency name : "
                            + currencyName
                            + ";"
                            + " expected :"
                            + expected
                            + " percent; actual : "
                            + actual
                            + " percent");

            BigDecimal threshold = new BigDecimal("0.5");

            // 计算差值并进行比较
            if (expected.subtract(actual).abs().compareTo(threshold) > 0) {
                return false;
            }

            // 点击返回顶部按钮
            waitForElement(coinmarketcapSpotExchangesDetailsPage.backToTopButton).click();
        }
        return true;
    }
}
