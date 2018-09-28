package com.kv.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/hello")
    public String hello() {
        JSONObject entity = new JSONObject();
        entity.put("key", "Hello");
        return entity.toString();
    }

    @GetMapping(path = "/hello2")
    public String hello2() {
        JSONObject entity = new JSONObject();
        entity.put("key", "Hello2");
        return entity.toString();
    }

    @GetMapping(path = "/hello3")
    public String hello3() {
        JSONObject entity = new JSONObject();
        entity.put("key", "Hello3");
        return entity.toString();
    }
}
