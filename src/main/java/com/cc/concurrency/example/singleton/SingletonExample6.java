package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 在类被装载的时候创建
 * Created by think on 2018.05.23.
 */
@ThreadSafe
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6(){

    }

    //单利对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    //静态工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
