package com.cc.concurrency.example.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 修饰代码块
 * Created by think on 2018.05.22.
 */
public class SynchronizedExample1 {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}" ,j,i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}" ,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() ->{
            example1.test1(1);
        });
        service.execute(() ->{
            example2.test1(2);
        });
    }
}
