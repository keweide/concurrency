package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.NotRecommend;
import com.cc.concurrency.annoations.NotThreadSafe;
import com.cc.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式 =》双重同步锁单例模式
 * 在类第一次被使用时创建
 * Created by think on 2018.05.23.
 */
@NotThreadSafe
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4(){

    }

    //单利对象
    private static SingletonExample4 instance = null;
    //静态工厂方法
    public static SingletonExample4 getInstance(){
        if (instance == null){//双重检测机制
            synchronized (SingletonExample4.class){//同步锁
                if (instance == null){
                    instance = new SingletonExample4();
                }
            }

        }
        return instance;
    }
}
