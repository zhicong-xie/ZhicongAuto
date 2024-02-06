package com.zhiCong.Plaform.Project.Step;

import com.zhiCong.Plaform.Project.Flow.ChromeFlow;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ChromeStep {

  private ChromeFlow chromeFlow;

  public ChromeStep() {
    chromeFlow = new ChromeFlow();
  }

  @Given("^the user open \"([^\"]*)\" url on Google Chrome$")
  public void openUrlOnGoogleChrome(String url) {
    chromeFlow.openUrlOnGoogleChrome(url);
  }

  @Then("^the Browser is opening \"([^\"]*)\" url on Google Chrome$")
  public void isBrowserOpenUrl(String expected) {
    String msg = String.format("The Browser is not opening this %s url", expected);
    String actual = chromeFlow.getBrowserOpenUrl();
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user switch to (last|first) window$")
  public void userSwitchToWindow(String item) {
    chromeFlow.userSwitchToWindow(item);
  }

  @When("^the user quit app$")
  public void quitApp() {
    chromeFlow.quitApp();
  }

  @When("^the user Maximize window$")
  public void maximizeWindow() {
    chromeFlow.maximizeWindow();
  }
}
