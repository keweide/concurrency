package com.cc.concurrency.example.lock;

import com.cc.concurrency.ConcurrencyTest;
import com.cc.concurrency.annoations.ThreadSafe;
import com.sun.org.apache.bcel.internal.generic.FNEG;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by think on 2018.05.22.
 */
public class LockExample3 {


    private final static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);

    private final Map<String,Data> map = new TreeMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public Data get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    //如果要写入，不能有任何读取操作
    public Data put(String key,Data value){
        writeLock.lock();
        try {
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
    class Data{

    }

}
