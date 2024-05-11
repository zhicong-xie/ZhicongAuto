package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.CoinmarketcapCurrencyDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CoinmarketcapCurrencyDetailsFlow extends BaseFlow {

  private CoinmarketcapCurrencyDetailsPage coinmarketcapCurrencyDetailsPage;
  private WebDriver webDriver;

  public CoinmarketcapCurrencyDetailsFlow() {
    coinmarketcapCurrencyDetailsPage = new CoinmarketcapCurrencyDetailsPage();
    webDriver = WebDriverConfig.getDriver();
  }

  public boolean isCurrencyDetailsScreenDisplayed() {
    return checkForElement(coinmarketcapCurrencyDetailsPage.coinmarketcapCurrencyDetailsTitle);
  }

  public String getLoomNetWorkCopy() {
    return waitForElement(coinmarketcapCurrencyDetailsPage.loomNetWorkAboutCopy)
        .getText()
        .replaceAll("\n", "")
        .trim();
  }

  public void clickFollowButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.followButton).click();
    waitForSeconds(8);
  }

  public void clickWatchlistButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.watchlistButton).click();
  }

  public void clickChartButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.chartButton).click();
    // 等待页面刷新
    waitForSeconds(3);
  }

  public void clickMarketsButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.marketsButton).click();
    // 等待页面刷新
    waitForSeconds(3);
  }

  public void clickAboutButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.aboutButton).click();
    // 等待页面刷新
    waitForSeconds(3);
  }

  public void selectMetamaskIcon() {
    waitForElement(coinmarketcapCurrencyDetailsPage.metamaskIcon).click();
  }

  public void selectShowRows(String item) throws IllegalAccessException {
    // 滑动到rowsDropDown 并点击
    swipeToDownFindElementByJs(coinmarketcapCurrencyDetailsPage.rowsDropDown).click();

    // 选择row option
    switch (item) {
      case "10":
        waitForElement(coinmarketcapCurrencyDetailsPage.tenRows).click();
        break;
      case "20":
        waitForElement(coinmarketcapCurrencyDetailsPage.twentyRows).click();
        break;
      case "50":
        waitForElement(coinmarketcapCurrencyDetailsPage.fiftyRows).click();
        break;
      case "100":
        waitForElement(coinmarketcapCurrencyDetailsPage.oneHundredRows).click();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", item));
    }

    // 再次等待表格刷新
    waitForSeconds(3);
  }

  public boolean isVolumePercentageCorrect(String item) {

    // 获取 LOOM Volume value
    String totalString = waitForElement(coinmarketcapCurrencyDetailsPage.totalVolume).getText();
    BigDecimal totalVolume =
        new BigDecimal(
            keepNumbersDecimalPoints(totalString.substring(totalString.indexOf("$") + 1)));
    System.out.println("Volume (24h) total value is " + totalVolume);

    // 获取整个表格的数据
    swipeDownToFindElement(coinmarketcapCurrencyDetailsPage.invalidSequence);

    List<WebElement> marketsName = coinmarketcapCurrencyDetailsPage.marketsName;
    List<WebElement> marketsVolume = coinmarketcapCurrencyDetailsPage.marketsVolume;
    List<WebElement> marketsVolumePercentage =
        coinmarketcapCurrencyDetailsPage.marketsVolumePercentage;
    HashMap<BigDecimal, BigDecimal> marketsData = new HashMap<>();

    for (int i = 0; i < marketsName.size(); i++) {
      if (marketsName.get(i).getText().trim().equals(item)) {
        marketsData.put(
            new BigDecimal(keepNumbersDecimalPoints(marketsVolumePercentage.get(i).getText())),
            new BigDecimal(keepNumbersDecimalPoints(marketsVolume.get(i).getText())));
      }
    }

    System.out.println(String.format("%s Volume data : ", item) + marketsData);

    // 校验 item 的 Volume % 与 显示的误差少于0.2%

    for (BigDecimal expectedVolumePercentage : marketsData.keySet()) {

      BigDecimal actualVolume = marketsData.get(expectedVolumePercentage);
      BigDecimal actualVolumePercentage =
          actualVolume.multiply(new BigDecimal("100")).divide(totalVolume, 2, RoundingMode.HALF_UP);

      BigDecimal differenceVolumePercentage =
          expectedVolumePercentage.subtract(actualVolumePercentage).abs();

      // 打印输出计算具体数据
      System.out.println(String.format("%s actual Volume : ", item) + actualVolume);
      System.out.println(
          String.format("%s expected Volume percentage : ", item) + expectedVolumePercentage + "%");
      System.out.println(
          String.format("%s actual Volume percentage : ", item) + actualVolumePercentage + "%");
      System.out.println(
          String.format("%s difference Volume percentage : ", item)
              + differenceVolumePercentage
              + "%\n");

      // 判断计算的Volume%与预期相差是否少于0.2%
      if (differenceVolumePercentage.compareTo(new BigDecimal("0.2")) > 0) {
        System.out.println(
            String.format("%s difference volume percentage is greater than 0.2 percentage", item));
        return false;
      }
    }
    return true;
  }

  public boolean verifyOneDayChartAlignResponse()
      throws IOException, ParseException, IllegalAccessException {

    // 获取API response，并仅保留所需的数据
    HashMap<String, HashMap<BigDecimal, BigDecimal>> expectedData =
        getOneDayLoomPriceData(
            getApiResponse(
                "https://api.coinmarketcap.com/data-api/v3/cryptocurrency/detail/chart?id=2588&range=1D",
                "GET"));

    // 等待图标刷新
    waitForSeconds(3);

    // 获取3次随机元素坐标
    List<Integer> randomCoordinates =
        getRandomCoordinatesForElement(
            3, waitForElement(coinmarketcapCurrencyDetailsPage.chartView, 120));

    HashMap<String, HashMap<String, String>> actualData = new LinkedHashMap<>();

    // 获取随机三点的实际弹窗数据
    for (Integer x : randomCoordinates) {

      mouseMovementForCoordinate(coinmarketcapCurrencyDetailsPage.chartView, x, 0);
      waitForSeconds(3);
      HashMap<String, String> data = new HashMap<>();
      String date = coinmarketcapCurrencyDetailsPage.chartPartialModelDate.getText().trim();
      String time = coinmarketcapCurrencyDetailsPage.chartPartialModelTime.getText().trim();
      String price = coinmarketcapCurrencyDetailsPage.chartPartialModelPrice.getText().trim();
      String vol = coinmarketcapCurrencyDetailsPage.chartPartialModelVol.getText().trim();
      data.put(price, vol);
      actualData.put(date + " " + time, data);
    }

    System.out.println("Actual data : " + actualData);

    for (String time : actualData.keySet()) {

      // 如果该时间戳存在于 expectedData(API response) 当中，则判断数据是否准确
      if (expectedData.containsKey(time) || expectedData.containsKey("0" + time)) {
        HashMap<BigDecimal, BigDecimal> expect;

        // 由于图标返回时期格式有 M/dd/yyyy 和 MM/dd/yyyy
        if (expectedData.containsKey(time)) {
          expect = expectedData.get(time);
        } else {
          expect = expectedData.get("0" + time);
        }

        HashMap<String, String> actual = actualData.get(time);
        System.out.println(String.format("%s expect data is %s", time, expect));
        System.out.println(String.format("%s actual data is %s", time, actual));

        for (String actualPrice : actual.keySet()) {

          // 判断Price 预期(保留小数点后5位并四舍五入)与实际的值是否相等

          BigDecimal expectPriceBigDecimal =
              expect.keySet().iterator().next().setScale(5, RoundingMode.HALF_UP);
          BigDecimal actualPriceBigDecimal = new BigDecimal(keepNumbersDecimalPoints(actualPrice));

          System.out.println(
              String.format(
                  "expect Price value is %s; actual Price value is %s",
                  expectPriceBigDecimal, actualPriceBigDecimal));

          if (actualPriceBigDecimal.compareTo(expectPriceBigDecimal) != 0) {
            return false;
          }

          BigDecimal expectVolBigDecimal = expect.get(expect.keySet().iterator().next());
          BigDecimal actualVolBigDecimal = virtualCurrencyUnitConversion(actual.get(actualPrice));

          System.out.println(
              String.format(
                  "expect Vol value is %s; actual Vol value is %s",
                  expectVolBigDecimal, actualVolBigDecimal));

          // 判断Vol 预期与实际的差少于与其两者最大值0.1%
          BigDecimal max;
          if (expectVolBigDecimal.compareTo(actualVolBigDecimal) > 0) {
            max = expectVolBigDecimal;
          } else {
            max = actualVolBigDecimal;
          }
          BigDecimal onePercentOfMax = max.divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP);
          System.out.println(String.format("one percent for max value is %s", onePercentOfMax));
          if (expectVolBigDecimal.subtract(actualVolBigDecimal).abs().compareTo(onePercentOfMax)
              > 0) {
            System.out.println(
                "The difference between the expected vol and the actual vol is too large");
            return false;
          }
        }
      } else {
        System.out.println(String.format("%s time is not exist expectedData", time));
        return false;
      }
    }

    return true;
  }
}
