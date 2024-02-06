package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Base.LocaleCSVParser;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.GlobalLiveCryptocurrencyChartsPage;
import org.openqa.selenium.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GlobalLiveCryptocurrencyChartsFlow extends BaseFlow {

  private GlobalLiveCryptocurrencyChartsPage globalLiveCryptocurrencyChartsPage;
  private WebDriver webDriver;

  public GlobalLiveCryptocurrencyChartsFlow() {
    globalLiveCryptocurrencyChartsPage = new GlobalLiveCryptocurrencyChartsPage();
    webDriver = WebDriverConfig.getDriver();
  }

  public boolean isGlobalLiveCryptocurrencyChartsDisplayed() {
    return checkForElement(globalLiveCryptocurrencyChartsPage.globalLiveCryptocurrencyChartsTitle);
  }

  public void clickMarketCapOneDayButton() {
    // 滑动到顶部
    if (checkForElement(globalLiveCryptocurrencyChartsPage.backToTopButton, 3)) {
      globalLiveCryptocurrencyChartsPage.backToTopButton.click();
    }
    waitForElement(globalLiveCryptocurrencyChartsPage.marketCapOneDayButton).click();
  }

  public void clickVolumeOneDayButton() {
    // 滑动到顶部
    if (checkForElement(globalLiveCryptocurrencyChartsPage.backToTopButton, 3)) {
      globalLiveCryptocurrencyChartsPage.backToTopButton.click();
    }
    waitForElement(globalLiveCryptocurrencyChartsPage.volumeOneDayButton).click();
  }

  public void clickBitcoinDominanceOneDayButton() {
    waitForElement(globalLiveCryptocurrencyChartsPage.bitcoinDominanceOneDayButton).click();
  }

  public boolean verifyMarketCapOneDayResponse()
      throws IOException, ParseException, IllegalAccessException {

    // 等待图表刷新
    waitForSeconds(5);

    // 获取API response
    HashMap<String, BigDecimal> actualData =
        getMarketCapData(
            getApiResponse(
                String.format(
                    LocaleCSVParser.getLocaleValue("Market_Cap_One_Day_url"),
                    getPreviousDay(),
                    getNextsDay()),
                "GET"));

    System.out.println("Market cap data: \n" + actualData);

    // 实现鼠标悬停

    mouseMovement(globalLiveCryptocurrencyChartsPage.marketCapChat);

    // 数据验证
    boolean isAmountGreaterThanZero = true;

    for (String key : actualData.keySet()) {
      if (actualData.get(key).compareTo(BigDecimal.ZERO) < 0) {
        isAmountGreaterThanZero = false;
        break;
      }
    }
    String time =
        globalLiveCryptocurrencyChartsPage.marketCapOneDayTooltipDate.getText()
            + " "
            + globalLiveCryptocurrencyChartsPage.marketCapOneDayTooltipTime.getText();

    System.out.println("Time : " + time);

    String expectedAmount =
        globalLiveCryptocurrencyChartsPage.marketCapOneDayTooltipAmount.getText();

    System.out.println("expected amount : " + expectedAmount);

    BigDecimal actualAmount = actualData.get(time);

    System.out.println("actual amount : " + actualAmount);

    BigDecimal diffPercentage =
        (virtualCurrencyUnitConversion(expectedAmount).subtract(actualAmount).abs())
            .divide(virtualCurrencyUnitConversion(expectedAmount), 2);

    return actualData.containsKey(time)
        && diffPercentage.compareTo(new BigDecimal("0.05")) <= 0
        && isAmountGreaterThanZero
        && virtualCurrencyUnitConversion(expectedAmount).compareTo(BigDecimal.ZERO) > 0;
  }

  public boolean verifyVolumeOneDayResponse()
      throws IOException, ParseException, IllegalAccessException {

    waitForSeconds(5);

    // 获取API response
    HashMap<String, BigDecimal> actualData =
        getVolumeData(
            getApiResponse(
                String.format(
                    LocaleCSVParser.getLocaleValue("Volume_One_Day_url"),
                    getPreviousDay(),
                    getNextsDay()),
                "GET"));

    System.out.println("Volume data: \n" + actualData);

    // 实现鼠标悬停

    mouseMovement(globalLiveCryptocurrencyChartsPage.volumeChat);

    // 数据验证
    boolean isAmountGreaterThanZero = true;

    for (String key : actualData.keySet()) {
      if (actualData.get(key).compareTo(BigDecimal.ZERO) < 0) {
        isAmountGreaterThanZero = false;
        break;
      }
    }

    String time =
        globalLiveCryptocurrencyChartsPage.volumeOneDayTooltipDate.getText()
            + " "
            + globalLiveCryptocurrencyChartsPage.volumeOneDayTooltipTime.getText();

    System.out.println("Time : " + time);

    String expectedAmount = globalLiveCryptocurrencyChartsPage.volumeOneDayTooltipAmount.getText();

    System.out.println("expected amount : " + expectedAmount);

    BigDecimal actualAmount = actualData.get(time);

    System.out.println("actual amount : " + actualAmount);

    BigDecimal diffPercentage =
        (virtualCurrencyUnitConversion(expectedAmount).subtract(actualAmount).abs())
            .divide(virtualCurrencyUnitConversion(expectedAmount), 2);

    return actualData.containsKey(time)
        && diffPercentage.compareTo(new BigDecimal("0.2")) <= 0
        && isAmountGreaterThanZero
        && virtualCurrencyUnitConversion(expectedAmount).compareTo(BigDecimal.ZERO) > 0;
  }

  public boolean verifyBitcoinDominanceOneDayResponse() throws IOException, ParseException {

    waitForSeconds(5);

    // 获取API response
    HashMap<String, HashMap<String, BigDecimal>> actualDatas =
        getBitcoinDominanceData(
            getApiResponse(LocaleCSVParser.getLocaleValue("Bitcoin_Dominance_One_Day_url"), "GET"));

    System.out.println("Bitcoin dominance data: \n" + actualDatas);

    // 实现鼠标悬停

    mouseMovement(globalLiveCryptocurrencyChartsPage.bitcoinDominanceChat);

    // 数据验证

    String time =
        globalLiveCryptocurrencyChartsPage.bitcoinDominanceOneDayTooltipDate.getText()
            + " "
            + globalLiveCryptocurrencyChartsPage.bitcoinDominanceOneDayTooltipTime.getText();

    System.out.println("Time : " + time);

    List<WebElement> dataList =
        globalLiveCryptocurrencyChartsPage.bitcoinDominanceOneDayTooltipDataList;

    List<String> expectedData = new ArrayList<>();

    String data = "";
    for (int i = 0; i < dataList.size(); i++) {
      if ((i + 1) % 3 == 0) {
        data = data + dataList.get(i).getText().trim();
      } else if (i % 3 == 0 && i != 0) {
        data = data + dataList.get(i).getText().trim();
        expectedData.add(data);
        data = "";
      }
    }

    System.out.println("expected data : " + expectedData);

    HashMap<String, BigDecimal> actualDate = actualDatas.get(time);

    boolean isTotalCurrencyAmountCorrect = true;

    boolean isCurrencyPercentageCorrect = true;

    BigDecimal actualCurrencyPercentage;

    for (String string : expectedData) {
      String expectedCurrencyName = string.split(":")[0].trim();
      BigDecimal expectedCurrencyPercentage =
          new BigDecimal(keepNumbersDecimalPoints(string.split(":")[1].trim()));

      if (expectedCurrencyName.equalsIgnoreCase("others")) {
        int i = 0;
        BigDecimal othersCurrency = new BigDecimal(0);
        for (String keys : actualDate.keySet()) {

          if (i >= 5) {
            if (!(keys.equalsIgnoreCase("global"))) {
              othersCurrency = othersCurrency.add(actualDate.get(keys));
            }
          }
          i++;
        }
        actualCurrencyPercentage =
            (othersCurrency.multiply(new BigDecimal(100)).divide(actualDate.get("global"), 2));

      } else {
        actualCurrencyPercentage =
            actualDate
                .get(expectedCurrencyName)
                .multiply(new BigDecimal(100))
                .divide(actualDate.get("global"), 2);
      }

      BigDecimal differenceCurrencyPercentage =
          expectedCurrencyPercentage.subtract(actualCurrencyPercentage).abs();

      System.out.println(
          String.format(
              "%s expect currency percentage is %s percentage; actual percentage is %s percentage;\nThe percentage difference between the two is %s \n",
              expectedCurrencyName,
              expectedCurrencyPercentage,
              actualCurrencyPercentage,
              differenceCurrencyPercentage));

      if (differenceCurrencyPercentage.compareTo(new BigDecimal("0.5")) > 0) {
        isCurrencyPercentageCorrect = false;
        System.out.println("The percentage of both exceeds 0.5%");
        break;
      }
    }

    BigDecimal totalCurrencyAmount = new BigDecimal(0);
    for (String key : actualDate.keySet()) {
      if (key.equalsIgnoreCase("global")) {
        totalCurrencyAmount = totalCurrencyAmount.add(actualDate.get(key));
      }
    }

    BigDecimal differenceTotalAmount = totalCurrencyAmount.subtract(actualDate.get("global")).abs();

    System.out.println(
        "The difference between the two total amount values is " + differenceTotalAmount);

    if (differenceTotalAmount.compareTo(new BigDecimal("100")) > 0) {
      isTotalCurrencyAmountCorrect = false;
      System.out.println("The difference between the two values is more than 1000");
    }

    return isCurrencyPercentageCorrect && isTotalCurrencyAmountCorrect;
  }
}
