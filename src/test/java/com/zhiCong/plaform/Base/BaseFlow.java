package com.zhiCong.Plaform.Base;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Maps.newLinkedHashMap;

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
    ((JavascriptExecutor) webDriver)
        .executeScript(String.format("window.scrollBy(0, %d);", defaultSwipePixel));
  }

  protected void swipeToDown(int pixel) {
    ((JavascriptExecutor) webDriver).executeScript(String.format("window.scrollBy(0, %d);", pixel));
  }

  protected void swipeToDownFindElement(WebElement webElement) {
    ((JavascriptExecutor) webDriver)
        .executeScript("arguments[0].scrollIntoView(false);", webElement);
  }

  protected void swipeToBottom() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    int pageHeight = ((Long) js.executeScript("return document.body.scrollHeight")).intValue();

    while (true) {
      int currentPosition = ((Long) js.executeScript("return window.pageYOffset")).intValue();
      if (currentPosition >= pageHeight - 800) {
        System.out.println("The page has slid to the bottom");
        break;
      } else {
        swipeToDown();
        waitForSeconds(2);
      }
    }
  }

  protected WebElement findByText(String text) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    return w.until(
        ExpectedConditions.visibilityOf(
            webDriver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", text)))));
  }

  protected void mouseMovementAndClickElement(WebElement webElement) {
    Actions actions = new Actions(webDriver);
    actions.moveToElement(webElement).click().perform();
  }

  protected String keepNumbersDecimalPoints(String data) {
    Pattern pattern = Pattern.compile("[^0-9.]");
    Matcher matcher = pattern.matcher(data);
    return matcher.replaceAll("");
  }

  protected void switchToLastWindow() {
    ArrayList<String> windows = new ArrayList<>(webDriver.getWindowHandles());
    webDriver.switchTo().window(windows.get(windows.size() - 1));
  }

  protected void switchToFirstWindow() {
    ArrayList<String> windows = new ArrayList<>(webDriver.getWindowHandles());
    webDriver.switchTo().window(windows.get(0));
  }

  protected void switchToSpecificWindow(int windowIndex) {
    ArrayList<String> windows = new ArrayList<>(webDriver.getWindowHandles());
    try {
      webDriver.switchTo().window(windows.get(windowIndex));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected JSONObject getApiResponse(String link, String requestMethod) throws IOException {
    JSONObject jsonObject = new JSONObject(newLinkedHashMap());

    URL url = new URL(link);

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    try {
      connection.setRequestMethod(requestMethod);

      int responseCode = connection.getResponseCode();

      if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
          response.append(line);
        }

        reader.close();

        jsonObject = new JSONObject(response.toString());

        System.out.println("Api response: \n" + jsonObject);

      } else {
        System.err.println("error code" + responseCode);
      }

    } catch (Error e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }

    return jsonObject;
  }

  protected HashMap<String, BigDecimal> getMarketCapData(JSONObject jsonObject) {
    HashMap<String, BigDecimal> hashMap = new HashMap<>();

    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("quotes");

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject obj = jsonArray.getJSONObject(i);

      JSONArray jsonArray1 = obj.getJSONArray("quote");
      JSONObject object = jsonArray1.getJSONObject(0);
      String timestamp = object.getString("timestamp");
      BigDecimal totalMarketCap = object.getBigDecimal("totalMarketCap");
      hashMap.put(timestamp, totalMarketCap);
    }

    System.out.println("Market cap data: \n" + hashMap);

    return hashMap;
  }
}
