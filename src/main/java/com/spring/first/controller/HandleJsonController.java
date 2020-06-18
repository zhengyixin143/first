package com.spring.first.controller;

import com.spring.first.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController //少了这个注解会导致访问不了项目
public class HandleJsonController {

    @GetMapping("/demo")
    //get方式请求，定义两个参数，id和name
    //http://localhost:9090/demo?id=2&name=sum
    public String demo(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name) {
        return "id"+id+name;

    }

    @PostMapping(path = "/demo2")
    public void demo2(Person person)
    {
        System.out.println(person.toString());
    }


    //post方式请求，定义两个参数 name age
    //localhost:9090/postdemo
    @PostMapping("/postdemo")
    public String hello(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return "name：" + name + "\nage：" + age;
    }




}
