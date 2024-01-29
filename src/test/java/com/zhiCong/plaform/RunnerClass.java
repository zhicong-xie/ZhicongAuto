package com.zhiCong.Plaform;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
      "pretty",
      "html:target/cucumber-report/",
      "json:target/cucumber-report/cucumber.json"
    },
    tags = "@AC7.13",
    features = {"src/test/resources/Feature"})
public class RunnerClass {}
