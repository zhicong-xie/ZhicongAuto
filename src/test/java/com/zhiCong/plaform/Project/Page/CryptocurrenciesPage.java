package com.zhiCong.Plaform.Project.Page;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CryptocurrenciesPage {

    private WebDriver webDriver;

    public CryptocurrenciesPage(){
            WebDriverConfig.getInstance();
            webDriver  = WebDriverConfig.getDriver();
            PageFactory.initElements(webDriver, this);
        }

    @FindBy(xpath = "//a[@class = 'sc-f2e7c84b-2 bOPkpb cmc-logo tooltip']")
    public WebElement coinmarketcapTitle;

    @FindBy(id = "drop-anchor")
    public WebElement ReadMoreLink;

    @FindBy(xpath = "//div[@class = 'sc-adbfcfff-3 dDrhas']")
    public List<WebElement> currencyNameList;

    @FindBy(xpath = "//div[@class = 'sc-4ce79553-0 hHIalA visible']")
    public WebElement backToTopButton;

    @FindBy(xpath = "//div[@class = 'sc-e20acb0c-1 fWcxPm']")
    public WebElement searchBar;

    @FindBy(id = "section-coin-overview")
    public WebElement coinmarketcapCurrencyDetailsTitle;

    @FindBy(xpath = "//div[@class = 'sc-8829bc3d-6 eHPaKU']/input")
    public WebElement searchInputBar;

    @FindBy(xpath = "//div[@class = 'sc-cca68cc8-1 kLnjVg']")
    public WebElement searchRustltList;

    @FindBy(xpath = "//div[@class = 'sc-8b3d12a8-1 hDjzmZ menu-item-1']")
    public WebElement exchangeButton;

    @FindBy(xpath = "//div[@class ='sc-f70bb44c-0 dcmrty']")
    public WebElement topCryptocurrencySpotExchangesTitle;

    @FindBy(xpath = "//h1[@class = 'sc-aba8b85a-0 sc-d36bb8b9-3 dtdOWf']")
    public WebElement binanceSpotExchangesDetailsTitle;

    @FindBy(xpath = "//span[@class = 'sc-4984dd93-0 fREVOF priceText']")
    public WebElement spotExchangesDetailsBalance;

    @FindBy(xpath = "//*[contains (@class, 'sc-b27a436d-10 LQXt')]/p[@class = 'sc-4984dd93-0 kKpPOn']")
    public List<WebElement> chartFilterCurrencyButtonList;

    @FindBy(xpath = "//*[contains (@class, 'sc-b27a436d-10 LQXt')]/p[@class = 'sc-4984dd93-0 cEFVjA']")
    public List<WebElement> chartFilterProportionList;

    @FindBy(xpath = "//table[@class = 'sc-feda9013-3 gLzycC cmc-table  ']//td[contains(@style, 'text-align:')]")
    public List<WebElement> refinedBalanceList;

    @FindBy(xpath = "//div[@class = 'sc-b27a436d-8 kbhqyE']//*[contains(text(),'Load More')]/..")
    public WebElement loadingMoreButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesAndContinueButton;

    @FindBy(xpath = "//div[@class = 'sc-f70bb44c-0 hNnCrE top']")
    public WebElement loomNetWorkTitle;

    @FindBy(xpath = "//div[@class = 'sc-f70bb44c-0 lcMKAk show']//p")
    public List<WebElement> loomNetWorkDescriptionList;

}
