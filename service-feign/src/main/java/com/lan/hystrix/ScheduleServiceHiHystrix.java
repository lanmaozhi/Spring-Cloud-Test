package com.lan.hystrix;

import com.lan.feign.ScheduleServiceHi;
import org.springframework.stereotype.Component;

@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi {

    @Override
    public String sayHiFromClient(String name) {

        return "sorry " + name;
    }
}
