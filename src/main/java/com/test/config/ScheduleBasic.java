package com.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;


@Configuration
@EnableScheduling
public class ScheduleBasic {

    @Scheduled(cron = "0 * * * * *")//Chạy vào 0s của mỗi phút
    public void showTime() {
        System.out.println("Now is" + new Date());
    }


}
