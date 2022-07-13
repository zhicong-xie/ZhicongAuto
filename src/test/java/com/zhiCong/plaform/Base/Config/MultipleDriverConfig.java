package com.zhiCong.Plaform.Base.Config;

import com.zhiCong.Plaform.Tools.YmlMultipleDriverTools;
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
  private String key;
  private HashMap<String, String> driverHashMap;

  public MultipleDriverConfig(String key, HashMap<String, String> driverHashMap) {
    this.key = key;
    this.driverHashMap = driverHashMap;
  }

  @Override
  public AppiumDriver call() {
    System.out.println("Running " + key);
    DesiredCapabilities des = new DesiredCapabilities();
    String proxy = null;
    for (String capabilityName : driverHashMap.keySet()) {
      if (capabilityName.equals("proxy")) {
        proxy = driverHashMap.get(capabilityName);
        System.out.println(key + "'s proxy : " + proxy);
      }else {
        des.setCapability(capabilityName, driverHashMap.get(capabilityName));
      }
    }
    System.out.println(key + " des details : " + des);
    try {
      System.out.println(String.format("http://127.0.0.1:%s/wd/hub", proxy));
      driver = new AppiumDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", proxy)), des);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    System.out.println("Thread " + key + " exiting.");
    return driver;
  }

  public static List<AppiumDriver> getDriverList() throws ExecutionException, InterruptedException {
    if (appiumDriverList == null || appiumDriverList.isEmpty()) {
      appiumDriverList = new ArrayList<>();
      HashMap<String, HashMap<String, String>> multipleDriver =
          YmlMultipleDriverTools.getYmlMultipleDriver();
      for (String key : multipleDriver.keySet()) {
        FutureTask<AppiumDriver> futureTask =
            new FutureTask(new MultipleDriverConfig(key, multipleDriver.get(key)));
        Thread thread = new Thread(futureTask);
        thread.start();
        appiumDriverList.add(futureTask.get());
      }
      System.out.println("appium driver list : " + appiumDriverList);
    }
    return appiumDriverList;
  }

  static class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      List<AppiumDriver> list = getDriverList();
      for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i).getCapabilities());
      }
    }
  }
}
