package com.linkinstars.springBootTemplate.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Demo读取配置测试
 * @author LinkinStar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoConfigTest {

    @Autowired
    private DemoConfig demoConfig;

    @Test
    public void getDemoConfig(){
        System.out.println(demoConfig.getId());
        System.out.println(demoConfig.getVal());
    }
}
