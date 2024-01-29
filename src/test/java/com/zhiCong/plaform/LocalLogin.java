package com.zhiCong.Plaform;

import com.zhiCong.Plaform.Base.LocaleCSVParser;
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

      LocaleCSVParser.getInstance();



      System.out.println(LocaleCSVParser.getLocaleValue("About_LOOM_Network_title"));

      System.out.println(LocaleCSVParser.getLocaleValue("About_LOOM_Network_description"));





  }
}
