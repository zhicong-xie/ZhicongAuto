//package com.zhiCong.Plaform.Tools;
//
//import io.appium.java_client.AppiumDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//import io.appium.java_client.service.local.flags.GeneralServerFlag;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.ServerSocket;
//import java.net.URL;
//
//public class AppiumServerTools {
//  private AppiumDriverLocalService service;
//  private AppiumServiceBuilder builder;
//  private DesiredCapabilities des;
//  private AppiumDriver appiumDriver;
//
//  public void startServer(int proxy) {
//    // Set Capabilities
//    des = new DesiredCapabilities();
//        des.setCapability("app",
//     "/Users/automatiautomationon/Downloads/pizzahut_crm_android-app-pizzahut-uat-release-1.2.3-84-20180110.apk");
//          des.setCapability("platformName", "Android");
//          des.setCapability("platformVersion", "11.0");
//          des.setCapability("deviceName", "emulator-5554");
//          des.setCapability("automationName", "UiAutomator2");
//    //    des.setCapability("app", "/Users/automatiautomationon/Downloads/PizzaHut_CRM_UAT.app");
//    //    des.setCapability("platformName", "iOS");
//    //    des.setCapability("platformVersion", "15.5");
//    //    des.setCapability("deviceName", "iPhone 13");
//    //    des.setCapability("automationName", "XCUITest");
//    // Build the Appium service
//    builder = new AppiumServiceBuilder();
//    builder.withIPAddress("127.0.0.1");
//    builder.usingPort(proxy);
//    builder.withCapabilities(des);
//    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//    builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
//    // Start the server with the builder
//    service = AppiumDriverLocalService.buildService(builder);
//    service.start();
//
//    try {
//      appiumDriver =
//          new AppiumDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", proxy)), des);
//    } catch (MalformedURLException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void stopServer() {
//    service.stop();
//  }
//
//  public boolean checkIfServerIsRunning(int port) {
//    boolean isServerRunning = false;
//    ServerSocket serverSocket;
//    try {
//      serverSocket = new ServerSocket(port);
//      serverSocket.close();
//    } catch (IOException e) {
//      // If control comes here, then it means that the port is in use
//      isServerRunning = true;
//    } finally {
//      serverSocket = null;
//    }
//    return isServerRunning;
//  }
//
//  public static void main(String[] args) {
//    AppiumServerTools appiumServer = new AppiumServerTools();
//    int proxy = 4723;
//    if (!appiumServer.checkIfServerIsRunning(proxy)) {
//      appiumServer.startServer(proxy);
//      System.out.println("success");
//      appiumServer.stopServer();
//    } else {
//      System.out.println("Appium Server already running on Port - " + proxy);
//    }
//  }
//}
