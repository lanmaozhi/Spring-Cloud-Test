package com.lan.controller;

import com.lan.feign.ScheduleServiceHi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private ScheduleServiceHi scheduleServiceHi;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name) {
        return scheduleServiceHi.sayHiFromClient(name);
    }
}
