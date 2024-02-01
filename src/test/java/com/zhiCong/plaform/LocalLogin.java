package com.zhiCong.Plaform;

import com.google.gson.JsonArray;
import com.zhiCong.Plaform.Base.LocaleCSVParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.Date;

public class LocalLogin {

  public static void main(String[] args) throws IOException {

    URL url =
        new URL(
            "https://api.coinmarketcap.com/data-api/v3/global-metrics/quotes/historical?format=chart&timeStart=1705914420&timeEnd=1706544000&interval=15m");

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    try {
      connection.setRequestMethod("GET");

//      connection.addRequestProperty("Accept", "application/json");

      int responseCode = connection.getResponseCode();

      if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
          response.append(line);
        }

        reader.close();

        System.out.println("服务器返回的响应：\n" + response.toString());
        JSONObject jsonObj = new JSONObject(response.toString());
        JSONArray jsonArray = jsonObj.getJSONObject("data").getJSONArray("quotes");

        HashMap<String, BigDecimal> data = new HashMap<>();

        for (int i = 0; i < jsonArray.length(); i++) {
          JSONObject obj = jsonArray.getJSONObject(i);

          JSONArray jsonArray1 = obj.getJSONArray("quote");
          JSONObject object = jsonArray1.getJSONObject(0);
          String timestamp = object.getString("timestamp");
          BigDecimal totalMarketCap = object.getBigDecimal("totalMarketCap");
          data.put(timestamp, totalMarketCap);
        }

        System.out.println(data);

      } else {
        System.err.println("请求失败，错误码：" + responseCode);
      }


    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 关闭连接
      connection.disconnect();
    }




//    CloseableHttpClient httpClient = HttpClients.createDefault();
//
//    String url = "https://api.coinmarketcap.com/data-api/v3/global-metrics/quotes/historical?format=chart&timeStart=1705914420&timeEnd=1706544000&interval=15m";
//    HttpGet request = new HttpGet(url);
//
//    try (CloseableHttpResponse response = httpClient.execute(request)) {
//      // 处理响应结果
//
//      int statusCode = response.getStatusLine().getStatusCode();
//      if (statusCode == 200) {
//        // 读取响应内容
//
//        // 将响应转换为字符串
//        String responseBody = EntityUtils.toString(response.getEntity());
//
//        System.out.println(responseBody);
//
//        JSONObject jsonObj = new JSONObject(responseBody);
//        String specificValue = jsonObj.getString("totalVolume24HReported");
//
//        System.out.println("Specific value: " + specificValue);
//      } else {
//        System.err.println("Request failed with status code: " + statusCode);
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    } finally {
//      httpClient.close();
//    }

//    BigDecimal a = new BigDecimal(61546696588.5111);
//    System.out.println(a.divide(new BigDecimal(1000000000000.00),2));



  }
}
