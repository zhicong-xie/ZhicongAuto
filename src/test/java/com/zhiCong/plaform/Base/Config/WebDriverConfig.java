package com.zhiCong.Plaform.Base.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {

  private static WebDriver webDriver;
  private static WebDriverConfig webDriverConfig;

  public static WebDriverConfig getInstance() {
    if (webDriverConfig == null) {
      webDriverConfig = new WebDriverConfig();
    }
    return webDriverConfig;
  }

  private WebDriverConfig() {
    System.setProperty(
        "webdriver.chrome.driver",
        "/Users/automatiautomationon/Downloads/chromedriver-mac-x64/chromedriver");
    webDriver = new ChromeDriver();
  }

  public static WebDriver getDriver() {
    return webDriver;
  }
}
