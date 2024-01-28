package com.zhiCong.Plaform;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.Date;

public class LocalLogin {

  public static void main(String[] args) throws InterruptedException, ParseException {



      System.setProperty("webdriver.chrome.driver","/Users/automatiautomationon/Downloads/chromedriver-mac-x64/chromedriver");
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--user-data-dir=/Users/automatiautomationon/Chrome profile/Profile 1");


      WebDriver webDriver = new ChromeDriver(chromeOptions);

      webDriver.get("https://baidu.com");

      Actions actions = new Actions(webDriver);

      WebElement moreBtn = webDriver.findElement(By.name("tj_briicon"));
      actions.moveToElement(moreBtn);

      WebElement mp3Link = webDriver.findElement(By.xpath("//a[@name = 'tj_mp3']"));


      actions.moveToElement(mp3Link).click().perform();





  }
}
