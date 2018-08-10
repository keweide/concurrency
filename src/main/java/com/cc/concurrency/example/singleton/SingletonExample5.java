package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.NotThreadSafe;
import com.cc.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式 =》双重同步锁单例模式
 * 在类第一次被使用时创建
 * Created by think on 2018.05.23.
 */
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){

    }

    //单利对象
    //volatile限制指令重排
    private volatile static SingletonExample5 instance = null;
    //静态工厂方法
    public static SingletonExample5 getInstance(){
        if (instance == null){//双重检测机制
            synchronized (SingletonExample5.class){//同步锁
                if (instance == null){
                    instance = new SingletonExample5();
                }
            }

        }
        return instance;
    }
}
