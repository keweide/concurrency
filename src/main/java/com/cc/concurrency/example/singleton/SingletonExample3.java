package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.NotRecommend;
import com.cc.concurrency.annoations.NotThreadSafe;
import com.cc.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 在类第一次被使用时创建
 * Created by think on 2018.05.23.
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    
//    private SingletonExample3(){
//        
//    }
//    
//    private static SingletonExample3 instance = null;
//    
//    public static SingletonExample3 getInstance(){
//        if (instance == null)
//            instance = new SingletonExample3();
//        
//        return instance;
//    }
    
    
    
    

    //私有构造函数
    private SingletonExample3(){

    }

    //单利对象
    private static SingletonExample3 instance = null;
    //静态工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
