package com.zhiCong.Plaform;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

import static com.google.common.collect.Maps.newLinkedHashMap;

public class aaa {

  public static void main(String[] args) throws IOException, ParseException {

      // 假设 "1715374200" 是一个表示秒数的字符串
      long timestamp = Long.parseLong("1715374200");

      // 创建 Date 对象
      Date date = new Date(timestamp * 1000L); // 因为时间戳通常是以秒为单位，所以我们需要将其转换为毫秒

      // 创建 SimpleDateFormat 对象，并设置所需的格式
      SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy h:mm:ss aa");

      // 使用 SimpleDateFormat 对象格式化 Date 对象
      String formattedDate = sdf.format(date);

      // 输出结果
      System.out.println(formattedDate);

  }
}
