package com.zhiCong.Plaform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

public class ReportRunner {
  @Test
  public void generateReport() throws IOException {
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
  }
}
