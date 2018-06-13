package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("thymeleaf")
public class HelloControl {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello world！thymeleaf lee...";
    }

}
