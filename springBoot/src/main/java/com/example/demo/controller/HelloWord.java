package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bernie
 * @Date 2019/1/21 14:01
 **/
@RestController
public class HelloWord {

    @RequestMapping("/index")
    public Map<String,Object> index(@RequestParam("username") String username){
        //int i = 1/0;
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code","0000");
        resultMap.put("data","0000");
        resultMap.put("Message",username+"请求成功....");
        return resultMap;
    }
}
