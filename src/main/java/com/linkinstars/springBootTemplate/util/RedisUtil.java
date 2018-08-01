package com.linkinstars.springBootTemplate.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Redis操作工具类
 * @author LinkinStar
 */
public class RedisUtil {

    /**
     * RedisTemplate 使用的是 JdkSerializationRedisSerializer
     * StringRedisTemplate 使用的是 StringRedisSerializer
     * 之后可以通过构建redisTemplate来替换序列化的方式
     */
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 设置过期时间，单位秒
     * @param key 键的名称
     * @param timeout 过期时间
     * @return 成功：true，失败：false
     */
    public boolean setExpireTime(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 通过键删除一个值
     * @param key 键的名称
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 判断key是否存在
     * @param key 键的名称
     * @return 存在：true，不存在：false
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 字符串存储
     * @param key 键
     * @param value 值
     */
    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 字符串存储（同时设置超时时间）
     * @param key 键
     * @param value 值
     * @param timeout 超时时间（以秒为单位）
     */
    public void setStringAndExpireTime(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 字符串取值
     * @param key 键
     * @return 查询成功：值，查询失败，null
     */
    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 存储哈希表
     * @param key 整个哈希表的键
     * @param field 表中的键
     * @param value 表中的值
     */
    public void setHash(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 获取哈希表
     * @param key 整个哈希表的键
     * @param field 表中的键
     * @return 查询成功：值，查询失败，null
     */
    public Object getHash(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 删除哈希表中的某个元素
     * @param key 整个哈希表的键
     * @param fields 表中的键
     */
    public void deleteHash(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }
}
