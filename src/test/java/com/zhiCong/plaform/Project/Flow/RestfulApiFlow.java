package com.zhiCong.Plaform.Project.Flow;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestfulApiFlow {

  private static String apiKey = "aa75213a-f0cb-498f-8612-fc372d63e154";

  private String apiStates;
  private String apiResponse;

  public void restfulApiCallWithParameters(Map<String, String> data)
      throws IOException, URISyntaxException {

    String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";
    List<NameValuePair> parameters = new ArrayList<NameValuePair>();
    for (String key : data.keySet()) {
      parameters.add(new BasicNameValuePair(key, data.get(key)));
    }

    URIBuilder query = new URIBuilder(uri);
    query.addParameters(parameters);

    CloseableHttpClient client = HttpClients.createDefault();
    HttpGet request = new HttpGet(query.build());

    request.setHeader(HttpHeaders.ACCEPT, "application/json");
    request.addHeader("X-CMC_PRO_API_KEY", apiKey);

    CloseableHttpResponse response = client.execute(request);

    try {
      apiStates = response.getStatusLine().toString();
      HttpEntity entity = response.getEntity();
      apiResponse = EntityUtils.toString(entity);
      EntityUtils.consume(entity);
    } catch (IOException e) {
      System.out.println("Error: can't access content - " + e.toString());
    } finally {
      response.close();
    }
  }

  public void restfulApiCall() throws IOException, URISyntaxException {

    String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";

    URIBuilder query = new URIBuilder(uri);

    CloseableHttpClient client = HttpClients.createDefault();
    HttpGet request = new HttpGet(query.build());

    request.setHeader(HttpHeaders.ACCEPT, "application/json");
    request.addHeader("X-CMC_PRO_API_KEY", apiKey);

    CloseableHttpResponse response = client.execute(request);

    try {
      apiStates = response.getStatusLine().toString();
      HttpEntity entity = response.getEntity();
      apiResponse = EntityUtils.toString(entity);
      EntityUtils.consume(entity);
    } catch (IOException e) {
      System.out.println("Error: can't access content - " + e.toString());
    } finally {
      response.close();
    }
  }

  //    public void makeAPICall(String uri, List<NameValuePair> parameters)
  //            throws URISyntaxException, IOException {
  //
  //        URIBuilder query = new URIBuilder(uri);
  //        query.addParameters(parameters);
  //
  //        CloseableHttpClient client = HttpClients.createDefault();
  //        HttpGet request = new HttpGet(query.build());
  //
  //        request.setHeader(HttpHeaders.ACCEPT, "application/json");
  //        request.addHeader("X-CMC_PRO_API_KEY", apiKey);
  //
  //        CloseableHttpResponse response = client.execute(request);
  //
  //        try {
  //            apiStates =  response.getStatusLine().toString();
  //            HttpEntity entity = response.getEntity();
  //            apiResponse = EntityUtils.toString(entity);
  //            EntityUtils.consume(entity);
  //        } finally {
  //            response.close();
  //        }
  //    }

  public String getApiStates() {
    System.out.println("API States : " + apiStates);
    return apiStates;
  }

  public String getApiResponse() {
    return apiResponse;
  }
}
