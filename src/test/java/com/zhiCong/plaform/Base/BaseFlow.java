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
import java.math.RoundingMode;
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

  protected WebElement waitForElementClickable(WebElement webElement) {
    WebDriverWait w = new WebDriverWait(webDriver, defaultWaitingTime);
    w.until(ExpectedConditions.elementToBeClickable(webElement));
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
    int height = windowSize.height * 3 / 2;
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
    for (int i = 0; i < 10; i++) {
      if (checkForElement(webElement, 3)) {
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

  protected void mouseMovement(WebElement webElement) {
    Actions actions = new Actions(webDriver);
    for (int i = 0; i < defaultNumOfSwipe; i++) {
      actions.moveToElement(webElement).pause(2000).perform();
      waitForSeconds(1);
    }
  }

  protected void mouseMovementForCoordinate(WebElement webElement, Integer x, Integer y) {
    Actions actions = new Actions(webDriver);
    for (int i = 0; i < defaultNumOfSwipe; i++) {
      actions.moveToElement(webElement, x, y).pause(2000).build().perform();
      waitForSeconds(1);
    }
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

    System.out.println(String.format("Trying to get the response of %s API ...", url));

    try {
      connection.setRequestMethod(requestMethod);

      int responseCode = connection.getResponseCode();

      if (responseCode == HttpURLConnection.HTTP_OK) {
        System.out.println("Https Status Code is 200.");
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
          response.append(line);
        }

        reader.close();

        jsonObject = new JSONObject(response.toString());

        System.out.println("API response : " + jsonObject);

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

  protected String timestampFormatConversion(String before) {
    String afterTimestamp = "";

    long beforeTimestamp = Long.parseLong(before) * 1000L;

    SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat("MM/dd/yyyy h:mm:ss aa", Locale.ENGLISH);
    afterTimestamp = simpleDateFormat.format(beforeTimestamp);
    return afterTimestamp;
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
      case 'M':
        date = before.multiply(new BigDecimal(1000000.00));
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", unit));
    }
    System.out.println("Format after format conversion : " + date);
    return date;
  }

  protected HashMap<String, HashMap<BigDecimal, BigDecimal>> getOneDayLoomPriceData(
      JSONObject response) throws ParseException {

    HashMap<String, HashMap<BigDecimal, BigDecimal>> oneDayLoomPriceData = new LinkedHashMap<>();

    JSONObject object = response.getJSONObject("data").getJSONObject("points");

    for (String key : object.keySet()) {
      HashMap<BigDecimal, BigDecimal> data = new LinkedHashMap<>();
      JSONArray jsonArray = object.getJSONObject(key).getJSONArray("v");

      BigDecimal price = jsonArray.getBigDecimal(0).setScale(17, RoundingMode.HALF_UP);
      BigDecimal vol = jsonArray.getBigDecimal(1).setScale(2, RoundingMode.HALF_UP);
      data.put(price, vol);
      oneDayLoomPriceData.put(timestampFormatConversion(key), data);
    }

    System.out.println("1D LOOM Expected Price Data : " + oneDayLoomPriceData);

    return oneDayLoomPriceData;
  }

  protected List<Integer> getRandomCoordinatesForElement(Integer number, WebElement webElement) {
    List<Integer> data = new LinkedList<>();

    // 获取元素的尺寸
    Dimension elementSize = webElement.getSize();
    int width = (elementSize.getWidth()) * 3 / 4;

    for (int i = 0; i < number; i++) {
      Random random = new Random();
      int randomNumber = (random.nextInt(width + 1)) - (width / 2);
      data.add(randomNumber);
    }

    System.out.println("Random Coordinates : " + data);
    return data;
  }
}
