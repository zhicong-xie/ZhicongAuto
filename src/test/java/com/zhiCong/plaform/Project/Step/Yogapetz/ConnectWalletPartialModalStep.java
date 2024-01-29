package com.zhiCong.Plaform.Project.Step.Yogapetz;

import com.zhiCong.Plaform.Project.Flow.Yogapetz.ConnectWalletPartialModalFlow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ConnectWalletPartialModalStep {

  private ConnectWalletPartialModalFlow connectWalletPartialModalFlow;

  public ConnectWalletPartialModalStep() {
    connectWalletPartialModalFlow = new ConnectWalletPartialModalFlow();
  }

  @Then("^the user able to see Connect a Wallet partial modal$")
  public void isConnectWalletPartialModalDisplayed() {
    boolean expected = true;
    String msg = "the user can not direct to Connect a Wallet partial modal";
    boolean actual = connectWalletPartialModalFlow.isConnectWalletPartialModalDisplayed();
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user click \"([^\"]*)\" button on Connect a Wallet partial modal$")
  public void openUrlOnGoogleChrome(String button) {
    connectWalletPartialModalFlow.clickButtonByText(button);
  }

  @When(
      "^the user click (MetaMask|Get a Wallet|GET|Add to Chrome) button on Connect a Wallet partial modal$")
  public void clickButton(String btnName) throws IllegalAccessException {
    switch (btnName) {
      case "MetaMask":
        connectWalletPartialModalFlow.clickMetaMaskButton();
        break;
      case "Get a Wallet":
        connectWalletPartialModalFlow.clickGetWalletButton();
        break;
      case "GET":
        connectWalletPartialModalFlow.clickGETButton();
        break;
      case "Add to Chrome":
        connectWalletPartialModalFlow.clickAddToChromeButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }

  @Then("^the user able to see Chrome store screen$")
  public void isChromeStoreScreenDisplay() {
    boolean expected = true;
    String msg = "the user can not direct to Chrome store screen";
    boolean actual = connectWalletPartialModalFlow.isChromeStoreScreenDisplay();
    Assert.assertEquals(msg, expected, actual);
  }

  @When("^the user click (metamask io link|Got it button) on Chrome store screen$")
  public void clickChromeStoreElement(String btnName) throws IllegalAccessException {
    switch (btnName) {
      case "metamask io link":
        connectWalletPartialModalFlow.clickMetamaskIoLink();
        break;
      case "Got it button":
        connectWalletPartialModalFlow.clickGotItButton();
        break;
      default:
        throw new IllegalAccessException(String.format("unexpected value for %s", btnName));
    }
  }
}
