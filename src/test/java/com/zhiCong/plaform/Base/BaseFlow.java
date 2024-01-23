package com.zhiCong.Plaform.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFlow {

  private final int defaultWaitingTime = 20;

  int startX;
  int startY;
  int endX;
  int endY;

  protected boolean checkForElement(WebDriver webDriver, WebElement webElement) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    try {
      w.until(ExpectedConditions.visibilityOf(webElement));
      return webElement.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  protected WebElement waitForElement(WebDriver webDriver, WebElement webElement) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.visibilityOf(webElement));
  }

  protected WebElement waitForElements(WebDriver webDriver, List<WebElement> webElements) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
  }

  protected WebElement waitForElements(
          WebDriver webDriver, List<WebElement> webElements, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(webDriver, timeInSeconds);
    return w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
  }

  protected WebElement waitForElement(WebDriver webDriver, WebElement webElement, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(webDriver, timeInSeconds);
    return w.until(ExpectedConditions.visibilityOf(webElement));
  }

  protected void sleep(Long ms) {
    try {
      Thread.sleep(ms);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void swipeUp(WebDriver webDriver) {
//    TouchAction touchAction = new TouchAction(appiumDriver);
//    startX = endX = (int) appiumDriver.manage().window().getSize().width / 2;
//    startY = (int) appiumDriver.manage().window().getSize().height * 5 / 8;
//    endY = (int) appiumDriver.manage().window().getSize().height / 8;
//    new TouchAction(appiumDriver)
//        .press(PointOption.point(startX, startY))
//        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//        .moveTo(PointOption.point(endX, endY))
//        .release()
//        .perform();
  }
}
