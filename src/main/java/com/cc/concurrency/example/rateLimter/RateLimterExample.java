package com.cc.concurrency.example.rateLimter;

import com.cc.concurrency.example.publish.UnsafePublish;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class RateLimterExample {

    //采用令牌桶算法
    private static Logger log = LoggerFactory.getLogger(RateLimterExample.class);

    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100; i++) {
            if (rateLimiter.tryAcquire(300,TimeUnit.MILLISECONDS)) {
                handle(i);
            }
        }
    }

    private static void  handle(int i) {
        log.info("{}",i);
    }
}
