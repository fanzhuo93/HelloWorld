package com.kgc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 范卓
 * @Date 2020/6/16 9:35
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "hello")
public class HelloWorld {
    @GetMapping(value = "world")
    String say(){
        return "HelloWorld!";
    }
}
