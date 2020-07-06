package com.lan.service.impl;

import com.lan.service.IHelloService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloServiceImpl implements IHelloService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String sayHi(String name) {

        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }
}
