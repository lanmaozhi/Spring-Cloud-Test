package com.lan.controller;

import com.lan.service.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private IHelloService helloService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name) {

        return helloService.sayHi(name);
    }
}
