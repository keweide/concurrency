package com.cc.concurrency.example.atomic;

import com.cc.concurrency.ConcurrencyTest;
import com.cc.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by think on 2018.05.22.
 */
@ThreadSafe
public class AtomicExample5 {

    private final static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);

    private static AtomicIntegerFieldUpdater<AtomicExample5> update = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");


    public volatile int count = 100;

    public int getCount() {
        return count;
    }

    private static  AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if (update.compareAndSet(example5,100,120)){
            log.info("update success,{}",example5.getCount());
        }

        if (update.compareAndSet(example5,100,120)){
            log.info("update success,{}",example5.getCount());
        }else {
            log.info("update failed,{}",example5.getCount());
        }
    }
}
