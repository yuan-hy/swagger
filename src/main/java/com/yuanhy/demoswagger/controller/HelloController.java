package com.yuanhy.demoswagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanhy
 * @date 2020-12-19 16:22
 */
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello!";
    }
}
