package com.cc.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    private final static Logger log = LoggerFactory.getLogger(CountDownLatchExample.class);

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0;i < threadCount; i++){
            final int threadNum = i;
            executorService.execute(() ->{
                try {
                    test(threadNum);
                }catch (Exception e){
                    log.error("");
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}",threadNum);
        Thread.sleep(100);
    }
}
