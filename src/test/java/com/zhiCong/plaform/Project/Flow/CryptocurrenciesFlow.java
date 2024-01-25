package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.CryptocurrenciesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public int swipeDownGetAllCurrencyListSize(){
//        List<String> allCurrencyName = new ArrayList<>(150);
//        waitForElements(cryptocurrenciesPage.currencyNameList);
//        List<WebElement> currencyNameList;
//
//        while (true){
//            int i;
//            int num = 0;
//           currencyNameList =  cryptocurrenciesPage.currencyNameList;
//
//            for (i = 0 ; i <currencyNameList.size();i++){
//                if (!allCurrencyName.contains(currencyNameList.get(i).getText())){
//                    allCurrencyName.add(currencyNameList.get(i).getText());
//                }else {
//                    num++;
//                }
//            }
//
//            if (i==num && i!=0){
//                break;
//            }else {
//                swipeToDown();
//                num = 0;
//            }
//        }
//        System.out.println("All currency list : "+allCurrencyName);
//        return allCurrencyName.size();

        waitForElements(cryptocurrenciesPage.currencyNameList);
        swipeToBottom();
        List<WebElement> currencyNameList =  cryptocurrenciesPage.currencyNameList;
        List<String> allCurrencyName = new ArrayList<>();
        for (WebElement webElement :currencyNameList){
            allCurrencyName.add(webElement.getText());
        }
        System.out.println("All currency list : "+allCurrencyName);
        return currencyNameList.size();
        }

    public void clickBackToTopButton(){
        waitForElement(cryptocurrenciesPage.backToTopButton).click();
    }

    public void clickSearchBar(){
        waitForElement(cryptocurrenciesPage.searchBar).click();
    }


    public void selectFirstSearchResult(){
        waitForElement(cryptocurrenciesPage.searchRustltList).click();
    }

    public void quitApp(){
        webDriver.quit();
    }

    public boolean isCurrencyDetailsScreenDisplayed(){
        return checkForElement(cryptocurrenciesPage.coinmarketcapCurrencyDetailsTitle);
    }

    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    public void inputSearchInputBar(String data){
        waitForElement(cryptocurrenciesPage.searchInputBar).sendKeys(data);
    }

    public void clickExchangeButton(){
        waitForElement(cryptocurrenciesPage.exchangeButton).click();
    }

    public boolean isTopCryptocurrencySpotExchangesScreenDisplayed(){
        return checkForElement(cryptocurrenciesPage.topCryptocurrencySpotExchangesTitle);
    }

    public void selectSpotExchange(String spotExchangeName){
        findByText(spotExchangeName).click();
    }

    public boolean isBinanceSpotExchangesDetailsScreenDisplayed(){
        return checkForElement(cryptocurrenciesPage.binanceSpotExchangesDetailsTitle);
    }

    public boolean isBinanceExchangeProportionPrecise(){

        BigDecimal totalBalance = new BigDecimal(keepNumbersDecimalPoints(waitForElement(cryptocurrenciesPage.spotExchangesDetailsBalance).getText()));
        System.out.println("Binance total balance : "+totalBalance);
        List<WebElement> filerCurrency =  cryptocurrenciesPage.chartFilterCurrencyButtonList;
        for (int i = 0; i<filerCurrency.size()-1;i++){
            String currencyName = filerCurrency.get(i).getText();


            //如果Accept Cookies & Continue button 存在则点击
            if (checkForElement(cryptocurrenciesPage.acceptCookiesAndContinueButton,5)){
                cryptocurrenciesPage.acceptCookiesAndContinueButton.click();
            }

            //开始筛选货币列表
            filerCurrency.get(i).click();
            BigDecimal expected = new BigDecimal(keepNumbersDecimalPoints(cryptocurrenciesPage.chartFilterProportionList.get(i).getText()));

            boolean isListExpand = false;
            BigDecimal currentCurrencyAmount = BigDecimal.valueOf(0);

            //展开该表格的所有数据
            for (int j = 0; j<3; j++){
                if (checkForElement(cryptocurrenciesPage.loadingMoreButton,3)){
                    cryptocurrenciesPage.loadingMoreButton.click();
                    isListExpand = true;
                    swipeToDown();
                }
            }

            //获取该货币的金额
            List<WebElement> currencyAmountList = cryptocurrenciesPage.refinedBalanceList;
            for (int x = 0; x<currencyAmountList.size();x++){
                if ((x+1)%3==0){
                    BigDecimal amount = new BigDecimal(keepNumbersDecimalPoints(currencyAmountList.get(x).getText()));
                    currentCurrencyAmount = currentCurrencyAmount.add(amount);
                    }else {
                    continue;
                }
            }

            //获取展开列表的数据
            if (isListExpand){
                List<WebElement> expandAmountList = cryptocurrenciesPage.expandBalanceList;
                for (int y = 0; y<expandAmountList.size(); y++){
                    if ((y+1)%3==0){
                        BigDecimal amount = new BigDecimal(keepNumbersDecimalPoints(expandAmountList.get(y).getText()));
                        currentCurrencyAmount = currentCurrencyAmount.add(amount);
                    }else {
                        continue;
                    }
                }
            }
            System.out.println(String.format("%s currency total balance : %s",currencyName,currentCurrencyAmount));
            BigDecimal actual = (currentCurrencyAmount.multiply(new BigDecimal(100))).divide(totalBalance,2);
            System.out.println("Currency name : "+currencyName + ";"+" expected :"+expected +" percent; actual : "+actual+" percent");

            BigDecimal threshold = new BigDecimal("0.5");

            // 计算差值并进行比较
            if (expected.subtract(actual).abs().compareTo(threshold) > 0) {
                return false;
            }

            //点击返回顶部按钮
            waitForElement(cryptocurrenciesPage.backToTopButton).click();
            }
            return true;
        }



    }
