package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.CryptocurrenciesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
