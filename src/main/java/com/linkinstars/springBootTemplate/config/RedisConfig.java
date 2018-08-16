package com.linkinstars.springBootTemplate.config;

import com.linkinstars.springBootTemplate.util.ProtostuffSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * redisTemplate初始化,开启spring-session redis存储支持
 * @author LinkinStar
 */
@Configuration
@EnableRedisHttpSession
public class RedisConfig {

    /**
     * redisTemplate 序列化使用的Serializeable, 存储二进制字节码, 所以自定义序列化类
     * @Rparam redisConnectionFactory
     * @return redisTemplate
     */
    @Bean
    public RedisTemplate<Object, Object> protoStuffTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // redis value使用的序列化器
        template.setValueSerializer(new ProtostuffSerializer());
        // redis key使用的序列化器
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }
}
