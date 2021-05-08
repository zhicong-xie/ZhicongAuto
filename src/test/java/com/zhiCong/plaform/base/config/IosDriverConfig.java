package com.zhiCong.plaform.base.config;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IosDriverConfig {
    private static IOSDriver driver;
    private static IosDriverConfig iosDriverConfig;
    public static IosDriverConfig getInstance(){
        if (iosDriverConfig == null && "ios".equals(System.getProperty("platform"))) {
            iosDriverConfig = new IosDriverConfig();
        }
        return iosDriverConfig;
    }
    private IosDriverConfig(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("app", "/Users/automatiautomationon/Downloads/PizzaHut_CRM_UAT.app");
        des.setCapability("platformName", "iOS");
        des.setCapability("platformVersion", "13.1");
        des.setCapability("deviceName", "iPhone 8");
        des.setCapability("automationName","XCUITest");
        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static IOSDriver getDriver(){
        return driver;
    }
}
