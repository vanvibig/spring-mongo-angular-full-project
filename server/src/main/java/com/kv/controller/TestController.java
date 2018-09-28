package com.kv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "HelloWorld";
    }

    @GetMapping(path = "/hello2")
    public String test() {
        return "HelloWorld2";
    }

    @GetMapping(path = "/hello3")
    public String test3() {
        return "HelloWorld3";
    }
}
