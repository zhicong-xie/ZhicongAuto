package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class PizzaHutLogonFlow extends BaseFlow {

  private List<AppiumDriver> appiumDriverList;

  @iOSFindBy(id = "Allow")
  public WebElement iosAllowButton;

  @AndroidFindBy(id = "hk_btn")
  @iOSFindBy(id = "splash btn hk en")
  public WebElement hkButton;

  @AndroidFindBy(id = "btnAlertPositive")
  public WebElement tipsConfirmButton;

  @AndroidFindBy(id = "btnSkip")
  @iOSFindBy(id = "Skip")
  public WebElement skipButton;

  @AndroidFindBy(id = "btnStart")
  public WebElement aosStartButton;

  @AndroidFindBy(id = "imgMenu")
  @iOSFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeButton")
  public WebElement menuButton;

  @AndroidFindBy(id = "imgProfile")
  @iOSFindBy(
      xpath =
          "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
  public WebElement profileButton;

  @AndroidFindBy(id = "txtAccountName")
  @iOSFindBy(xpath = "//XCUIElementTypeTextField")
  public WebElement usernameInputBox;

  @AndroidFindBy(id = "txtPw")
  @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField")
  public WebElement passwordInputBox;

  @AndroidFindBy(id = "btnLogin")
  @iOSFindBy(id = "general btn alert confirm en")
  public WebElement confirmButton;

  @AndroidFindBy(id = "imgMenuItem")
  @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
  public WebElement homeButton;

  @iOSFindBy(className = "XCUIElementTypeButton")
  public WebElement apiConfirmButton;

  public PizzaHutLogonFlow() throws ExecutionException, InterruptedException {

  }

  public void onLoginScreen() {
    for (int i = 0; i < appiumDriverList.size(); i++) {
      PageFactory.initElements(new AppiumFieldDecorator(appiumDriverList.get(i)), this);
      if (appiumDriverList.get(i).getPlatformName().equalsIgnoreCase("android")) {
        waitForElement(appiumDriverList.get(i), hkButton).click();
        if (checkForElement(appiumDriverList.get(i), tipsConfirmButton)) {
          tipsConfirmButton.click();
        }
        waitForElement(appiumDriverList.get(i), skipButton, 60).click();
        waitForElement(appiumDriverList.get(i), aosStartButton).click();
        waitForElement(appiumDriverList.get(i), menuButton).click();
        waitForElement(appiumDriverList.get(i), profileButton).click();
      } else if (appiumDriverList.get(i).getPlatformName().equalsIgnoreCase("ios")) {
        waitForElement(appiumDriverList.get(i), iosAllowButton).click();
        waitForElement(appiumDriverList.get(i), hkButton).click();
        waitForElement(appiumDriverList.get(i), skipButton, 60).click();
        waitForElement(appiumDriverList.get(i), menuButton).click();
        waitForElement(appiumDriverList.get(i), profileButton).click();
      }
    }
  }

  public void inputLogonInformation(Map<String, String> logonInformation) {
    for (int i = 0; i < appiumDriverList.size(); i++) {
      PageFactory.initElements(new AppiumFieldDecorator(appiumDriverList.get(i)), this);
      waitForElement(appiumDriverList.get(i), usernameInputBox);
      usernameInputBox.sendKeys(logonInformation.get("username"));
      passwordInputBox.sendKeys(logonInformation.get("password"));
    }
  }

  public void clickConfirmButton() {
    for (int i = 0; i < appiumDriverList.size(); i++) {
      PageFactory.initElements(new AppiumFieldDecorator(appiumDriverList.get(i)), this);
      if (appiumDriverList.get(i).getPlatformName().equalsIgnoreCase("ios")) {
        waitForElement(appiumDriverList.get(i), apiConfirmButton).click();
      } else if (appiumDriverList.get(i).getPlatformName().equalsIgnoreCase("android")) {
        waitForElement(appiumDriverList.get(i), confirmButton).click();
      }
    }
  }

  public boolean homeScreenDisplayed() {
    for (int i = 0; i < appiumDriverList.size(); i++) {
      PageFactory.initElements(new AppiumFieldDecorator(appiumDriverList.get(i)), this);
      if (!checkForElement(appiumDriverList.get(i), menuButton)) {
        return false;
      }
    }
    return true;
  }
}
