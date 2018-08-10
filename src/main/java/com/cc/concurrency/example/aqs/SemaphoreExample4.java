package com.cc.concurrency.example.aqs;

import ch.qos.logback.core.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample4 {

    private final static Logger log = LoggerFactory.getLogger(SemaphoreExample4.class);

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0;i < threadCount; i++){
            final int threadNum = i;
            executorService.execute(() ->{
                try {
                    if (semaphore.tryAcquire(5000,TimeUnit.MILLISECONDS)){//尝试等待多个许可
                        test(threadNum);
                        semaphore.release();
                    }
                }catch (Exception e){
                    log.error("");
                }
            });
        }
        log.info("finish");
        //线程池关闭不是立刻杀死线程，而是等线程执行完才杀死线程
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
