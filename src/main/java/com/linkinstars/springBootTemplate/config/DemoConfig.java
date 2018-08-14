package com.linkinstars.springBootTemplate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件中的信息
 * @author LinkinStar
 */
@Component
@ConfigurationProperties(prefix = "demo")
public class DemoConfig {
    private int id;
    private String val;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
