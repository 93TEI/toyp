package com.toyp.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class ScheduleService {
    // 초기값
    static int custom = 1;
    // 스케줄러
    @Scheduled(cron = "0/5 * * * * *")
    public static void temps(){
        custom=(int)Math.random()*100;
        System.out.println(custom);
    }
}