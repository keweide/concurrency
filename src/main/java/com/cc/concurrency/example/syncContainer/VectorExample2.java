package com.cc.concurrency.example.syncContainer;

import com.cc.concurrency.ConcurrencyTest;
import com.cc.concurrency.annoations.NotThreadSafe;
import com.cc.concurrency.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 同步容器的线程不安全例子
 * Created by think on 2018.05.24.
 */
@NotThreadSafe
public class VectorExample2 {

    private final static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
       while (true){
           for (int i= 0;i<10;i++){
               vector.add(i);
           }
           Thread thread1 = new Thread(){
               public void run(){
                   for (int i= 0;i<vector.size();i++){
                       vector.remove(i);
                   }
               }
           };
           Thread thread2 = new Thread(){
               public void run(){
                   for (int i= 0;i<vector.size();i++){
                       vector.get(i);
                   }
               }
           };
           thread1.start();
           thread2.start();
       }
    }
}

