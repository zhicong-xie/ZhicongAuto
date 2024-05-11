package com.zhiCong.Plaform;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
      "pretty",
      "html:target/cucumber-report/",
      "json:target/cucumber-report/cucumber.json"
    },
    //        tags = "@AC7.12",
    features = {"src/test/resources/Feature"})
public class RunnerClass {

  @AfterClass
  public static void generateReport() {
    System.out.println("The cucumber report is being generated. . .");
    File reportOutputDirectory = new File("target/cucumberReport");
    List<String> jsonFiles = new ArrayList();
    jsonFiles.add("target/cucumber-report/cucumber.json");
    String buildNumber = "v1.0";
    String projectName = "Zhicong cucumber Report";
    Configuration configuration = new Configuration(reportOutputDirectory, projectName);
    configuration.setBuildNumber(buildNumber);
    configuration.addClassifications("Browser", "Firefox");
    configuration.addClassifications("Branch", "release/1.0");
    configuration.setSortingMethod(SortingMethod.NATURAL);
    configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();
    System.out.println("The cucumber report generated!");
  }
}
