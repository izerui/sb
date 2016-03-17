package com.sb.hyh.component.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisClient(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public StringRedisTemplate getRedisClient() {
        return stringRedisTemplate;
    }
}