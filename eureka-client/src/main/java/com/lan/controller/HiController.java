package com.lan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HiController {

    private static final Logger logger = LoggerFactory.getLogger(HiController.class);

    @Value("${server.port}")
    String port;

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "lanmz") String name) {

        logger.info("info");
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping("/hello")
    public String sayHello() {

        String description = discoveryClient.description();
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("service-hi");

        return "hello";
    }
}
