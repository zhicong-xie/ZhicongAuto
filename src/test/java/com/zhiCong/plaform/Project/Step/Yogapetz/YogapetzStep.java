package com.zhiCong.Plaform.Project.Step.Yogapetz;

import com.zhiCong.Plaform.Project.Flow.Yogapetz.YogapetzFlow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class YogapetzStep {

  private YogapetzFlow yogapetzFlow;

  public YogapetzStep() {
    yogapetzFlow = new YogapetzFlow();
  }

  @Then("^the user able to see Yogapetz screen$")
  public void isYogapetzScreenDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to Yogapetz screen";
    boolean actual = yogapetzFlow.isYogapetzScreenDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user click (Menu|Setting) button on Yogapetz screen$")
  public void clickButton(String btnName) throws IllegalAccessException {
    switch (btnName) {
      case "Menu":
        yogapetzFlow.clickMenuButton();
        break;
      case "Setting":
        yogapetzFlow.clickSettingButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }

  @When("^the user click \"([^\"]*)\" button on Yogapetz screen$")
  public void openUrlOnGoogleChrome(String button) {
    yogapetzFlow.clickButtonByText(button);
  }
}
