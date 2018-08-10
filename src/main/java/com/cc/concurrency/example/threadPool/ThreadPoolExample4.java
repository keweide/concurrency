package com.cc.concurrency.example.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample4 {

    private final static Logger log = LoggerFactory.getLogger(ThreadPoolExample4.class);

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

//       executorService.schedule(new Runnable() {
//           @Override
//           public void run() {
//               log.info("schedule run");
//           }
//       },3,TimeUnit.SECONDS);

       executorService.scheduleAtFixedRate(new Runnable() {
           @Override
           public void run() {
               log.info("schedule run");
           }
       },1,3,TimeUnit.SECONDS);
//        executorService.shutdown();
    }
}
