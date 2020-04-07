package com.springcloud.demo.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${user.name}") //获取配置文件中对应属性的值
    private String userName;

    @Value("${user.age}")
    private Integer age;

    @GetMapping("/getName")
    public String getUserName() {
        return userName;
    }
    @GetMapping("/age")
    public Integer getAge() {
        return age;
    }

    @PostMapping("/postName")
    public String postName(@RequestBody Map<String, String> param) {
        return param.get("name");
    }
}