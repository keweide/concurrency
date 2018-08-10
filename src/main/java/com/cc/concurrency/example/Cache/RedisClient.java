package com.cc.concurrency.example.Cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class RedisClient {

    @Resource(name = "redisPool")
    private JedisPool jedisPool;
}
