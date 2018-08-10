package com.cc.concurrency.example.threadLocal;

/**
 * Created by think on 2018.05.24.
 */
public class RequestHolder {

    private final  static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void  add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
