package com.linkinstars.springBootTemplate.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * 定时任务配置
 * @author LinkinStar
 */
@Configuration
@EnableScheduling
public class TimeTaskConfig implements SchedulingConfigurer {

    /**
     * 配置定时任务线程池大小
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("time-task-%d").build();
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10, namedThreadFactory);
        taskRegistrar.setScheduler(executorService);
    }
}
