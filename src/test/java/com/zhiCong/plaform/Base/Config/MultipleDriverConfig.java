package com.zhiCong.Plaform.Base.Config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultipleDriverConfig implements Callable<AppiumDriver> {
  private static AppiumDriver driver;
  private static List<AppiumDriver> appiumDriverList;
  private String threadName;
  private String app;
  private String platformName;
  private String platformVersion;
  private String deviceName;
  private String automationName;
  private String proxy;

  public MultipleDriverConfig(
      String threadName,
      String app,
      String platformName,
      String platformVersion,
      String deviceName,
      String automationName,
      String proxy) {
    this.threadName = threadName;
    this.app = app;
    this.platformName = platformName;
    this.platformVersion = platformVersion;
    this.deviceName = deviceName;
    this.automationName = automationName;
    this.proxy = proxy;
  }

  @Override
  public AppiumDriver call() {
    System.out.println("Running " + threadName);
    DesiredCapabilities des = new DesiredCapabilities();
    des.setCapability("app", app);
    des.setCapability("platformName", platformName);
    des.setCapability("platformVersion", platformVersion);
    des.setCapability("deviceName", deviceName);
    des.setCapability("automationName", automationName);
    try {
      driver = new AppiumDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", proxy)), des);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    System.out.println("Thread " + threadName + " exiting.");
    return driver;
  }

  public static List<AppiumDriver> getDriverList() throws ExecutionException, InterruptedException {
    if (appiumDriverList == null || appiumDriverList.isEmpty()) {
      appiumDriverList = new ArrayList<>();
      FutureTask<AppiumDriver> futureTask1 =
          new FutureTask(
              new MultipleDriverConfig(
                  "device-1",
                  "/Users/automatiautomationon/Downloads/pizzahut_crm_android-app-pizzahut-uat-release-1.2.3-84-20180110.apk",
                  "Android",
                  "10.0",
                  "emulator-5554",
                  "UiAutomator2",
                  "4723"));
      FutureTask<AppiumDriver> futureTask2 =
          new FutureTask(
              new MultipleDriverConfig(
                  "device-2",
                  "/Users/automatiautomationon/Downloads/PizzaHut_CRM_UAT.app",
                  "ios",
                  "15.5",
                  "iPhone 13",
                  "XCUITest",
                  "4726"));
      Thread thread1 = new Thread(futureTask1);
      Thread thread2 = new Thread(futureTask2);
      thread1.start();
      thread2.start();
      appiumDriverList.add(futureTask1.get());
      appiumDriverList.add(futureTask2.get());
      System.out.println("appium driver list : " + appiumDriverList);
    }
    return appiumDriverList;
  }

  static class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      List<AppiumDriver> list = getDriverList();
      for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i).getPlatformName());
      }
    }
  }
}
