package com.linkinstars.springBootTemplate.timer;

import com.linkinstars.springBootTemplate.util.LogUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务配置
 * @author LinkinStar
 */
@Configuration
public class TimeTask {

    @Scheduled(cron = "0/2 * * * * ?")
    public void test1(){
        LogUtil.printLog("任务1：执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.printLog("任务1：执行完成");
    }

}
