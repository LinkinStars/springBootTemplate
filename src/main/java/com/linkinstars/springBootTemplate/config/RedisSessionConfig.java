package com.linkinstars.springBootTemplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * session存放redis
 * @author LinkinStar
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
