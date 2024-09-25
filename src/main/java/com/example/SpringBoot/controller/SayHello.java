package com.example.SpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {
    @RequestMapping("/greeting")
    public String sayHello(){
        return "Hello world";
    }
}
