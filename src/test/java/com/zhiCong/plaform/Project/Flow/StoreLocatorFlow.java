package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.MultipleDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StoreLocatorFlow extends BaseFlow {

  private List<AppiumDriver> appiumDriverList;

  @AndroidFindBy(id = "imgStore")
  @iOSFindBy(id = "index btn store get ticket en")
  public WebElement storeLocatorButton;

  @AndroidFindBy(id = "txtTitle")
  @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
  public List<WebElement> storeName;

  @AndroidFindBy(id = "imgABLeftBtn")
  @iOSFindBy(id = "general btn top menu")
  public WebElement menuButton;

  @AndroidFindBy(id = "imgMenuItem")
  @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
  public WebElement homeButton;

  public StoreLocatorFlow() throws ExecutionException, InterruptedException {
    appiumDriverList = MultipleDriverConfig.getDriverList();
  }

  public void clickStoreLocatorButton() {
    for (int i = 0; i < appiumDriverList.size(); i++) {
      PageFactory.initElements(new AppiumFieldDecorator(appiumDriverList.get(i)), this);
      waitForElement(appiumDriverList.get(i), storeLocatorButton, 50).click();
    }
  }

  public boolean swipeUpFindStore(String storename) {
    for (int i = 0; i < appiumDriverList.size(); i++) {
      PageFactory.initElements(new AppiumFieldDecorator(appiumDriverList.get(i)), this);
      List<String> storeNameList = new ArrayList<String>();
      waitForElements(appiumDriverList.get(i), storeName);
      String lastStoreName = "";
      int count = 0;
      while (true) {
        for (WebElement webElement : storeName) {
          if (!storeNameList.contains(webElement.getText().trim())) {
            storeNameList.add(webElement.getText().trim());
          }
        }
        if (count != 0) {
          if (lastStoreName.equals(storeNameList.get(storeNameList.size() - 1))) {
            System.out.println("All store name : " + storeNameList);
            break;
          }
        }
        count++;
        lastStoreName = storeName.get(storeName.size() - 1).getText().trim();
        swipeUp(appiumDriverList.get(i));
      }
      if (!storeNameList.contains(storename)) {
        return false;
      }
    }
    return true;
  }

  public void toHomeScreen() {
    for (int i = 0; i < appiumDriverList.size(); i++) {
      PageFactory.initElements(new AppiumFieldDecorator(appiumDriverList.get(i)), this);
      waitForElement(appiumDriverList.get(i), menuButton).click();
      waitForElement(appiumDriverList.get(i), homeButton).click();
    }
  }
}
