package com.zhiCong.Plaform.Project.Flow;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class ChromeFlow extends BaseFlow {

  private WebDriver webDriver;

  public ChromeFlow() {
    webDriver = WebDriverConfig.getDriver();
  }

  public void openUrlOnGoogleChrome(String url) {
    System.out.println(String.format("Opening %s link on Google Chrome", url));
    webDriver.get(url);
  }

  public String getBrowserOpenUrl() {
    return webDriver.getCurrentUrl();
  }

  public void userSwitchToWindow(String item) {
    waitForSeconds(10);
    switch (item) {
      case "last":
        switchToLastWindow();
        break;
      case "first":
        switchToFirstWindow();
        break;
    }
  }

  public void quitApp() {
    webDriver.quit();
    webDriver = null;
  }

  public void maximizeWindow() {
    webDriver.manage().window().maximize();
  }
}
