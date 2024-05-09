package com.zhiCong.Plaform.Base;

import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
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
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

  protected WebElement swipeToDownFindElementByJs(WebElement webElement) {
    ((JavascriptExecutor) webDriver)
        .executeScript("arguments[0].scrollIntoView(false);", webElement);
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    return w.until(ExpectedConditions.visibilityOf(webElement));
  }

  protected void swipeToBottom() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    Dimension windowSize = webDriver.manage().window().getSize();
    int height = windowSize.height*3/2;
    int pageHeight = ((Long) js.executeScript("return document.body.scrollHeight")).intValue();

    while (true) {
      int currentPosition = ((Long) js.executeScript("return window.pageYOffset")).intValue();
      if (currentPosition >= pageHeight - height) {
        System.out.println("The page has slid to the bottom");
        break;
      } else {
        swipeToDown();
        waitForSeconds(2);
      }
    }
  }

  protected void swipeDownToFindElement(WebElement webElement) {
    for (int i =0; i<10;i++){
      if (checkForElement(webElement,3)){
        break;
      }else {
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

  protected void mouseMovement(WebElement webElement) {
    Actions actions = new Actions(webDriver);
    for (int i = 0; i < defaultNumOfSwipe; i++) {
      actions.moveToElement(webElement).pause(2000).perform();
      waitForSeconds(1);
    }
  }

  protected void mouseMovementWithOffset(WebElement webElement, int xOffset, int yOffset) {
    Actions actions = new Actions(webDriver);
    actions.moveToElement(webElement, xOffset, yOffset).perform();
    waitForSeconds(5);
  }

  protected String keepNumbersDecimalPoints(String data) {
    Pattern pattern = Pattern.compile("[^\\d.-]");
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

  protected HashMap<String, BigDecimal> getMarketCapData(JSONObject jsonObject)
      throws ParseException {
    HashMap<String, BigDecimal> hashMap = new LinkedHashMap<>();

    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("quotes");

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject obj = jsonArray.getJSONObject(i);

      JSONArray jsonArray1 = obj.getJSONArray("quote");
      JSONObject object = jsonArray1.getJSONObject(0);
      String timestamp = object.getString("timestamp");
      BigDecimal totalMarketCap = object.getBigDecimal("totalMarketCap");
      hashMap.put(timestampFormatConversion(timestamp), totalMarketCap);
    }

    return hashMap;
  }

  protected HashMap<String, BigDecimal> getVolumeData(JSONObject jsonObject) throws ParseException {
    HashMap<String, BigDecimal> hashMap = new LinkedHashMap<>();

    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("quotes");

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject obj = jsonArray.getJSONObject(i);

      JSONArray jsonArray1 = obj.getJSONArray("quote");
      JSONObject object = jsonArray1.getJSONObject(0);
      String timestamp = object.getString("timestamp");
      BigDecimal totalMarketCap = object.getBigDecimal("totalVolume24H");
      hashMap.put(timestampFormatConversion(timestamp), totalMarketCap);
    }

    return hashMap;
  }

  protected String timestampFormatConversion(String before) throws ParseException {
    String after = "";

    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    Date date = inputFormat.parse(before);

    SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.ENGLISH);
    after = outputFormat.format(date);

    return after;
  }

  protected BigDecimal virtualCurrencyUnitConversion(String amount) throws IllegalAccessException {

    amount = amount.replaceAll("$", "");
    char unit = amount.charAt(amount.length() - 1);
    BigDecimal date;
    BigDecimal before = new BigDecimal(amount.substring(1, amount.length() - 1));

    switch (unit) {
      case 'T':
        date = before.multiply(new BigDecimal(1000000000000.00));
        break;
      case 'B':
        date = before.multiply(new BigDecimal(1000000000.00));
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", unit));
    }
    System.out.println("Format after format conversion : " + date);
    return date;
  }

  protected long getPreviousDay() {
    Calendar calendar = Calendar.getInstance();

    calendar.add(Calendar.DAY_OF_MONTH, -1);
    calendar.set(Calendar.SECOND, 0);

    long timestamp = calendar.getTimeInMillis() / 1000;

    System.out.println("Previous Day Timestamp : " + timestamp);

    return timestamp;
  }

  protected long getNextsDay() {
    Calendar calendar = Calendar.getInstance();

    calendar.add(Calendar.DAY_OF_MONTH, +1);

    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);

    long timestamp = calendar.getTimeInMillis() / 1000;

    System.out.println("Next Day Timestamp : " + timestamp);

    return timestamp;
  }

  protected HashMap<String, HashMap<String, BigDecimal>> getBitcoinDominanceData(
      JSONObject jsonObject) throws ParseException {

    HashMap<String, HashMap<String, BigDecimal>> actualData = new LinkedHashMap<>();

    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("quotes");

    for (int i = 0; i < jsonArray.length(); i++) {
      HashMap<String, BigDecimal> hashMap = new LinkedHashMap<>();
      JSONObject obj = jsonArray.getJSONObject(i);
      String timestamp = obj.getString("timestamp");
      JSONArray jsonArray1 = obj.getJSONArray("quote");

      for (int j = 0; j < jsonArray1.length(); j++) {

        if (jsonArray1.getJSONObject(j).getString("name").equalsIgnoreCase("others")) {
          hashMap.put("Others", jsonArray1.getJSONObject(j).getBigDecimal("marketCap"));
        } else if (jsonArray1.getJSONObject(j).getString("name").equals("global")) {
          hashMap.put("global", jsonArray1.getJSONObject(j).getBigDecimal("marketCap"));
        } else {
          hashMap.put(
              jsonArray1.getJSONObject(j).getString("symbol"),
              jsonArray1.getJSONObject(j).getBigDecimal("marketCap"));
        }
      }
      actualData.put(timestampFormatConversion(timestamp), hashMap);
    }
    return actualData;
  }
}
