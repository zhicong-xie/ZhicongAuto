package com.zhiCong.Plaform.Base;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseFlow {

  private final int defaultWaitingTime = 20;
  private final int defaultShortWaitingTime = 3;
  private final int defaultNumOfSwipe = 3;
  private WebDriver webDriver;
  private final int defaultSwipePixel = 600;

  public BaseFlow() {
    WebDriverConfig.getInstance();
    webDriver = WebDriverConfig.getDriver();
  }

  protected boolean checkForElement(WebElement webElement) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    try {
      w.until(ExpectedConditions.visibilityOf(webElement));
      return webElement.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  protected boolean checkForElement(WebElement webElement, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(webDriver, timeInSeconds);
    try {
      w.until(ExpectedConditions.visibilityOf(webElement));
      return webElement.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  protected WebElement waitForElement(WebElement webElement) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.visibilityOf(webElement));
  }

  protected WebElement waitForElement(WebElement webElement, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(webDriver, timeInSeconds);
    return w.until(ExpectedConditions.visibilityOf(webElement));
  }

  protected WebElement waitForElements(List<WebElement> webElements) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
  }

  protected WebElement waitForElements(List<WebElement> webElements, Integer timeInSeconds) {
    WebDriverWait w = new WebDriverWait(webDriver, timeInSeconds);
    return w.until(ExpectedConditions.visibilityOf(webElements.get(0)));
  }

  protected void waitForSeconds(int waitingSecods) {
    try {
      Thread.sleep(waitingSecods * 1000);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void swipeToDown() {
    ((JavascriptExecutor) webDriver).executeScript(String.format("window.scrollBy(0, %d);",defaultSwipePixel));
  }

  protected void swipeToDown(int pixel) {
    ((JavascriptExecutor) webDriver).executeScript(String.format("window.scrollBy(0, %d);",pixel));
  }


  protected void swipeToDownFindElement(WebElement webElement) {
    ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(false);", webElement);
  }

  protected void swipeToBottom(){
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    int pageHeight = ((Long)js.executeScript("return document.body.scrollHeight")).intValue();

    while (true){
      int currentPosition = ((Long)js.executeScript("return window.pageYOffset")).intValue();
      if (currentPosition >= pageHeight - 800){
        System.out.println("The page has slid to the bottom");
        break;
      } else {
        swipeToDown();
        waitForSeconds(2);
      }
    }
  }

  protected WebElement findByText(String text){
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]",text)))));
  }

  protected void mouseMovementAndClickElement(WebElement webElement){
    Actions actions = new Actions(webDriver);
    actions.moveToElement(webElement).click().perform();
  }

  protected String keepNumbersDecimalPoints(String data){
    Pattern pattern = Pattern.compile("[^0-9.]");
    Matcher matcher = pattern.matcher(data);
    return matcher.replaceAll("");
  }

  protected void switchToLastWindow(){
    ArrayList<String> windows = new ArrayList<>(webDriver.getWindowHandles());
    webDriver.switchTo().window(windows.get(windows.size()-1));
  }

  protected void switchToFirstWindow(){
    ArrayList<String> windows = new ArrayList<>(webDriver.getWindowHandles());
    webDriver.switchTo().window(windows.get(0));
  }

  protected void switchToSpecificWindow(int windowIndex){
    ArrayList<String> windows = new ArrayList<>(webDriver.getWindowHandles());
    try{
      webDriver.switchTo().window(windows.get(windowIndex));
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
