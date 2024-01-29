package com.zhiCong.Plaform.Base;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class LocaleCSVParser {

  private static HashMap<String, String> localeMap = new HashMap<>();

  public static String getLocaleValue(String key) {
    String value = "";
    if (localeMap.get(key) != null) {
      value = localeMap.get(key);
    } else {
      value = "Key or value is missing in csv file";
    }
    return value;
  }

  public static void getInstance() {
    if (localeMap.size() == 0) {
      String filePath =
          "/Users/automatiautomationon/Desktop/ZhicongWebAuto/src/test/resources/Locale/en.csv";

      try {
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withCommentMarker('/'));
        for (CSVRecord csvRecord : csvParser) {
          String key = csvRecord.get(0);
          String value = csvRecord.get(1);
          localeMap.put(key, value);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    System.out.println(localeMap);
  }
}
