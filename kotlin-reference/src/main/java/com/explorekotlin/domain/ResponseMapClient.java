package com.explorekotlin.domain;

import java.util.HashMap;
import java.util.Map;

public class ResponseMapClient {

    public static void main(String[] args) {
        ResponseMap responseMap = new ResponseMap();
        Map<String,Double> hmap=new HashMap<>();
        hmap.put("Weight", 4.99);
        responseMap.setResponseMap(hmap);

        System.out.println("responseMap "+ responseMap.getResponseMap());
    }

}
