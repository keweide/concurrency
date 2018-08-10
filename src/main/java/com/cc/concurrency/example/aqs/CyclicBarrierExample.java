package com.cc.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    private final static Logger log = LoggerFactory.getLogger(CyclicBarrierExample.class);

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final  int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(()->{
                try {
                    race(threadNum);
                }catch (Exception e){
                    log.error("");
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        barrier.await();
        log.info("{} continue",threadNum);
    }
}
