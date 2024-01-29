package com.zhiCong.Plaform.Base.Config;

import com.zhiCong.Plaform.Base.LocaleCSVParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {

  private static WebDriver webDriver;
  private static WebDriverConfig webDriverConfig;

  public static WebDriverConfig getInstance() {
    if (webDriverConfig == null) {
      webDriverConfig = new WebDriverConfig();
      LocaleCSVParser.getInstance();
    }
    return webDriverConfig;
  }

  private WebDriverConfig() {
    System.setProperty(
        "webdriver.chrome.driver",
        "/Users/automatiautomationon/Downloads/chromedriver-mac-x64/chromedriver");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments(
        "--user-data-dir=/Users/automatiautomationon/Chrome profile/Profile 1");
    webDriver = new ChromeDriver(chromeOptions);
  }

  public static WebDriver getDriver() {
    return webDriver;
  }
}
