package com.spring.first.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //少了这个注解会导致访问不了项目
public class HelloController {
    @RequestMapping("/hello1")

    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "Hello Spring Boot222!";
    }


}
