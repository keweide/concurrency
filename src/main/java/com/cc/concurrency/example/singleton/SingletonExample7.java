package com.cc.concurrency.example.singleton;

import com.cc.concurrency.annoations.Recommend;
import com.cc.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式，最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造函数
    private SingletonExample7(){

    }


    //静态工厂方法
    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

   private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法只被调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return  singleton;
        }
   }

   enum Number{
        ONE(1,"one"),TWO(2,"two"),THREE(3,"three");

        private int num;
        private String name;

        Number(int num,String name){
            this.num = num;
            this.name = name;
        }

       public int getNum() {
           return num;
       }

       public void setNum(int num) {
           this.num = num;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }
   }

    public static void main(String[] args) {
        System.out.println(Number.ONE.getName());
    }
}
