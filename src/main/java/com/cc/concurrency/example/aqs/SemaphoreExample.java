package com.cc.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class SemaphoreExample {

    private final static Logger log = LoggerFactory.getLogger(SemaphoreExample.class);

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0;i < threadCount; i++){
            final int threadNum = i;
            executorService.execute(() ->{
                try {
                    semaphore.acquire();//获取一个许可
                    test(threadNum);
                    semaphore.release();//释放一个许可
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
