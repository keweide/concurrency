package com.cc.concurrency.example.commonUnsafe;

import com.cc.concurrency.ConcurrencyTest;
import com.cc.concurrency.annoations.NotThreadSafe;
import com.cc.concurrency.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by think on 2018.05.24.
 */
@ThreadSafe
public class StringExample2 {



    private final static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);
    //请求总数
    private static int clientTotal = 5000;
    //同时并发执行的线程数
    private static int threadTotal = 200;

    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal;i ++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                }catch (Exception e){
                    log.info("");
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size :"+stringBuffer.length());
    }
    private static void update(){
        stringBuffer.append("1");
    }

}
