package com.zhiCong.plaform.base.config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverConfig {

    private static AndroidDriver driver;
    private static AndroidDriverConfig androidDriverConfig;
    public static AndroidDriverConfig getInstance(){
        if (androidDriverConfig == null && "android".equals(System.getProperty("platform"))) {
            androidDriverConfig = new AndroidDriverConfig();
        }
        return androidDriverConfig;
    }
    private AndroidDriverConfig(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("app", "/Users/automatiautomationon/Downloads/pizzahut_crm_android-app-pizzahut-uat-release-1.2.3-84-20180110.apk");
            des.setCapability("platformName", "Android");
            des.setCapability("platformVersion", "10.0");
            des.setCapability("deviceName", "emulator-5554");
            des.setCapability("automationName","UiAutomator2");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static AndroidDriver getDriver(){
        return driver;
    }
}
