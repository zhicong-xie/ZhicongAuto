package com.zhiCong.Plaform.Tools;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.HashMap;


public class YmlMultipleDriverTools {

    public static HashMap getYmlMultipleDriver(){
        HashMap<String,String> map = new HashMap<>();
        try {
            Yaml yaml = new Yaml();
            InputStream resourceAsStream = YmlMultipleDriverTools.class.getClassLoader().getResourceAsStream("multipleDriver.yml");
            map = yaml.load(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Multiple driver map : "+map);
        return map;
    }
}

