package com.cc.concurrency.example.immutable;

import com.cc.concurrency.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * Created by think on 2018.05.23.
 */
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    //map实例化方法一
    private final static ImmutableMap<Integer,Integer> map1 = ImmutableMap.of(1,2,3,4,5,6);
    //map实例化方法二
    private final static ImmutableMap map2 = ImmutableMap.builder().put(1,2).put(3,4).put(5,6).build();

    public static void main(String[] args) {
        list.add(4);

        set.add(4);

        map1.put(1,4);

        map2.put(1,4);
    }

}
