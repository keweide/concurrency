package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.NotThreadSafe;
import com.cc.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 在类被装载的时候创建
 * Created by think on 2018.05.23.
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){

    }

    //单利对象
    private static SingletonExample2 instance = new SingletonExample2();
    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
