package com.dp.vue.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: vue
 * Created by DP on 2020/10/21 17:28
 */
@RestController
public class CityController {

    @CrossOrigin
    @GetMapping("getWeather")
    public Map<String,String> getWeather(String name){
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        System.out.println(name);

        map1.put("荆州","红色暴雨，切记防范后方！");
        map1.put("益州","晴转多云，注意国势！");
        map1.put("洛阳","晴空万里，宜出兵！");
        map1.put("建业","小雨连绵，宜出其不意！");

        map2.put("message",map1.get(name));
        return map2;
    }
}
