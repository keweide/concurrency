package com.cc.concurrency.example.publish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by think on 2018.05.23.
 */
public class UnsafePublish {

    private static Logger log = LoggerFactory.getLogger(UnsafePublish.class);

    private String[] states = {"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        //对类私有属性的值进行修改
        unsafePublish.getStates()[0] = "d";

        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
