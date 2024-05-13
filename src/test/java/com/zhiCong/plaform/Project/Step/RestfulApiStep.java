package com.zhiCong.Plaform.Project.Step;

import com.zhiCong.Plaform.Project.Flow.RestfulApiFlow;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class RestfulApiStep {

  private RestfulApiFlow restfulApiFlow;

  public RestfulApiStep() {
    restfulApiFlow = new RestfulApiFlow();
  }

  @Given("^the user use Restful api call /v1/cryptocurrency/map api with parameters$")
  public void restfulApiCallWithParameters(Map<String, String> parameters)
      throws IOException, URISyntaxException {
    System.out.println("API parameters is : " + parameters);
    restfulApiFlow.restfulApiCallWithParameters(parameters);
  }

  @Given("^the user use Restful api call /v1/cryptocurrency/map api$")
  public void restfulApiCall() throws IOException, URISyntaxException {
    restfulApiFlow.restfulApiCall();
  }

  @When("^the user get Restful api call /v1/cryptocurrency/map api response$")
  public void restfulApiGetResponse() {
    System.out.println("API response is : " + restfulApiFlow.getApiResponse());
  }

  @Then("^the user able to see Restful api states is (.*)$")
  public void isSuccessStates(String expected) {
    String actual = restfulApiFlow.getApiStates();
    String msg = String.format("The api expected states is %s, but actual is %s", expected, actual);
    Assert.assertEquals(msg, true, actual.contains(expected));
  }
}
