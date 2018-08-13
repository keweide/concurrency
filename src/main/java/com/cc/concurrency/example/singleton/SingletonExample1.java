package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式
 *
 * 单例的实例在第一次引用时创建
 *
 * 在单线程时没问题，多线程情况下有问题
 * Created by think on 2018.05.23.
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){

    }
    //单利对象
    private static SingletonExample1 instance = null;

    //静态工厂方法来获取一个单例对象
    public static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
