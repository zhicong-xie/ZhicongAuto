package com.zhiCong.Plaform.Project.Flow.Coinmarketcap;

import com.zhiCong.Plaform.Base.BaseFlow;
import com.zhiCong.Plaform.Base.Config.WebDriverConfig;
import com.zhiCong.Plaform.Base.LocaleCSVParser;
import com.zhiCong.Plaform.Project.Page.Coinmarketcap.CoinmarketcapCurrencyDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
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

  public boolean checkLoomNetWorkCopy() {
    swipeToDownFindElementByJs(coinmarketcapCurrencyDetailsPage.loomNetWorkTitle);
    String loomNetworkTitle =
        waitForElement(coinmarketcapCurrencyDetailsPage.loomNetWorkTitle).getText().trim();
    String loomNetWorkDescription = "";
    for (WebElement webElement : coinmarketcapCurrencyDetailsPage.loomNetWorkDescriptionList) {
      loomNetWorkDescription = loomNetWorkDescription + webElement.getText().trim();
    }
    System.out.println("actual copy title" + loomNetworkTitle);
    System.out.println("actual copy description" + loomNetWorkDescription);

    return LocaleCSVParser.getLocaleValue("About_LOOM_Network_title").equals(loomNetworkTitle)
        && LocaleCSVParser.getLocaleValue("About_LOOM_Network_description")
            .equals(loomNetWorkDescription);
  }

  public void clickFollowButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.followButton).click();
    waitForSeconds(8);
  }

  public void clickWatchlistButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.watchlistButton).click();
  }

  public void clickChartButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.marketsButton).click();
    // 等待页面刷新
    waitForSeconds(3);
  }

  public void clickMarketsButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.marketsButton).click();
    // 等待页面刷新
    waitForSeconds(3);
  }

  public void clicAboutButton() {
    waitForElement(coinmarketcapCurrencyDetailsPage.marketsButton).click();
    // 等待页面刷新
    waitForSeconds(3);
  }

  public void selectMetamaskIcon(){
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
}
