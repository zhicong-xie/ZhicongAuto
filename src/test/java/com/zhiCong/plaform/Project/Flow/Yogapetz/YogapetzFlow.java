package com.zhiCong.Plaform.Project.Flow.Yogapetz;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.Yogapetz.YogapetzPage;
import org.openqa.selenium.WebDriver;

public class YogapetzFlow extends BaseFlow {

  private YogapetzPage yogapetzPage;
  private WebDriver webDriver;

  public YogapetzFlow() {
    yogapetzPage = new YogapetzPage();
    webDriver = WebDriverConfig.getDriver();
  }

  public boolean isYogapetzScreenDisplayed() {
    return checkForElement(yogapetzPage.yogapetzTitle);
  }

  public void clickMenuButton() {
    waitForElement(yogapetzPage.menuButton).click();
  }

  public void clickSettingButton() {
    waitForElement(yogapetzPage.settingButton).click();
  }

  public void clickButtonByText(String text) {
    findByText(text).click();
  }
}
