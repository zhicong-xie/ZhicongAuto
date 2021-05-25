package com.zhiCong.plaform.base.config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverConfig {

    private static AppiumDriver driver;
    private static DriverConfig driverConfig;
    public static DriverConfig getInstance(){
        if (driverConfig == null) {
            driverConfig = new DriverConfig();
        }
        return driverConfig;
    }

    private DriverConfig(){
        DesiredCapabilities des = new DesiredCapabilities();
        if ("android".equals(System.getProperty("platform"))){
            des.setCapability("app", "/Users/automatiautomationon/Downloads/pizzahut_crm_android-app-pizzahut-uat-release-1.2.3-84-20180110.apk");
            des.setCapability("platformName", "Android");
            des.setCapability("platformVersion", "10.0");
            des.setCapability("deviceName", "emulator-5554");
            des.setCapability("automationName","UiAutomator2");
        }else if ("ios".equals(System.getProperty("platform"))){
            des.setCapability("app", "/Users/automatiautomationon/Downloads/PizzaHut_CRM_UAT.app");
            des.setCapability("platformName", "iOS");
            des.setCapability("platformVersion", "13.1");
            des.setCapability("deviceName", "iPhone 8");
            des.setCapability("automationName","XCUITest");
        }

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static AppiumDriver getDriver(){
        return driver;
    }
}
