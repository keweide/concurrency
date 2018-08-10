package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 在类第一次被
 * Created by think on 2018.05.23.
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){

    }

    //单利对象
    private static SingletonExample1 instance = null;
    //静态工厂方法
    public static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
