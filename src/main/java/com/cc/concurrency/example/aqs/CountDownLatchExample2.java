package com.cc.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample2 {

    private final static Logger log = LoggerFactory.getLogger(CountDownLatchExample2.class);

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
        //指定等待时间，超过等待时间执行下面的程序，但是线程还是会执行完
        countDownLatch.await(10,TimeUnit.MILLISECONDS);
        log.info("finish");
        //线程池关闭不是立刻杀死线程，而是等线程执行完才杀死线程
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}",threadNum);
    }
}
