package com.cc.concurrency;

import com.cc.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.concurrent.*;

/**
 * Created by think on 2018.05.17.
 */

@NotThreadSafe
public class ConcurrencyTest {

    private final static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);
    //请求总数
    private static int clientTotal = 5000;
    //同时并发执行的线程数
    private static int threadTotal = 200;

    private static int count = 0;

    public static void main(String[] args) throws Exception {
        //定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，控制并发线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal;i ++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    log.info("");
                }
                countDownLatch.countDown();//每执行一次计数器减一
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count :"+ count);
    }
    private static void add(){
        count ++;
    }
}
