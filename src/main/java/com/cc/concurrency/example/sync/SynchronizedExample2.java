package com.cc.concurrency.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 修饰代码块
 * Created by think on 2018.05.22.
 */
public class SynchronizedExample2 {

    private static final Logger log = LoggerFactory.getLogger(SynchronizedExample2.class);

    //修饰一个类
    public static void test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}" ,j,i);
            }
        }
    }

    //修饰一个静态方法
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}" ,j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() ->{
            test1(1);

        });
        service.execute(() ->{
            test1(2);
        });
    }
}
