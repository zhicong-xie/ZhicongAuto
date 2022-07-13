package com.zhiCong.Plaform.Tools;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

public class AppiumServerTools {

  private static AppiumDriver driver;
  private AppiumDriverLocalService service;
  private AppiumServiceBuilder builder;

  public void startAppiumServer(int proxy) {
    builder = new AppiumServiceBuilder();
    builder.withIPAddress("127.0.0.1");
    builder.usingPort(proxy);
    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
    builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
    service = AppiumDriverLocalService.buildService(builder);
    service.start();
  }

  public void stopAppiumServer() {
    service.stop();
  }

  public void connectAppiumServer(int proxy) {
    DesiredCapabilities des = new DesiredCapabilities();
    des.setCapability(
        "app",
        "/Users/automatiautomationon/Downloads/pizzahut_crm_android-app-pizzahut-uat-release-1.2.3-84-20180110.apk");
    des.setCapability("platformName", "Android");
    des.setCapability("platformVersion", "10.0");
    des.setCapability("deviceName", "emulator-5554");
    des.setCapability("automationName", "UiAutomator2");
    try {
      driver = new AppiumDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub",proxy)), des);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public boolean checkIfServerIsRunnning(int port) {
    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
      serverSocket = new ServerSocket(port);
      serverSocket.close();
    } catch (IOException e) {
      isServerRunning = true;
    }
    return isServerRunning;
  }

  public static void main(String[] args) {
    AppiumServerTools appiumServer = new AppiumServerTools();
    int port = 4723;
    if (!appiumServer.checkIfServerIsRunnning(port)) {
      appiumServer.startAppiumServer(port);
      appiumServer.connectAppiumServer(port);
      appiumServer.stopAppiumServer();
    } else {
      System.out.println("Appium Server already running on Port - " + port);
    }
  }
}
