package com.cc.concurrency.example.publish;

import com.cc.concurrency.annoations.NotRecommend;
import com.cc.concurrency.annoations.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by think on 2018.05.23.
 */
@NotThreadSafe
@NotRecommend
public class Escape {

    private static Logger log = LoggerFactory.getLogger(UnsafePublish.class);

    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }
    //  内部类
    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
