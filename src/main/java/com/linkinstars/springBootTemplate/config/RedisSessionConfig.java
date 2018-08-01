package com.linkinstars.springBootTemplate.config;

import com.linkinstars.springBootTemplate.util.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * session存放redis以及redis工具初始化
 * @author LinkinStar
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {

    /**
     * 封装RedisTemplate
     */
    @Bean(name = "redisUtil")
    public RedisUtil redisUtil() {
        RedisUtil redisUtil = new RedisUtil();
        return redisUtil;
    }
}
