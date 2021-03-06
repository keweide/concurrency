package com.cc.concurrency.example.immutable;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by think on 2018.05.23.
 */
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        //引用类型初始化之后不能指向别的对象，但是能修改值
        map.put(1,3);
        System.out.println(map.get(1));
    }

    private void test(final int a){
//        a=1;
    }
}
