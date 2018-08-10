package com.cc.concurrency.example.Cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Bean(name = "redisPool")
    public JedisPool jedisPool(@Value("${reids.host}")String host,@Value("${redis.port}")int port){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(3 * 1000);
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(10);
        return new JedisPool(jedisPoolConfig,host,port,3000,"123456",0);
    }
}
