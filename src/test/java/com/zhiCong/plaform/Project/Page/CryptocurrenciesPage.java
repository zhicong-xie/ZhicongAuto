package com.zhiCong.Plaform.Project.Page;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CryptocurrenciesPage {

    private WebDriver webDriver;

    public CryptocurrenciesPage(){
            WebDriverConfig.getInstance();
            webDriver  = WebDriverConfig.getDriver();
            PageFactory.initElements(webDriver, this);
        }

    @FindBy(xpath = "//div[@class = \"container\"]")
    public WebElement coinmarketcapTitle;

  @FindBy(id = "drop-anchor")
  public WebElement ReadMoreLink;
}
