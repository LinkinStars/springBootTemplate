package com.linkinstars.springBootTemplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务配置
 * @author LinkinStar
 */
@Configuration
@EnableScheduling
public class TimeTaskConfig {

    @Scheduled(cron = "0/5 * * * * ?")
    public void test1(){
        System.out.println("任务1：执行");
    }
}
