package com.lan.service.impl;

import com.lan.service.IHelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloServiceImpl implements IHelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Resource
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String name) {

        logger.info("info");
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
