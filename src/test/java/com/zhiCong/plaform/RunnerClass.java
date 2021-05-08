package com.zhiCong.plaform;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                "pretty",
                "html:target/cucumber-report/",
                "json:target/cucumber-report/cucumber.json"
        },
        tags = "@Pizza",
        features={"src/test/resources/Feature"}
)

public class RunnerClass {
}