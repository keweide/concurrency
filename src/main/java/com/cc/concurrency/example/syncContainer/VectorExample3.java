package com.cc.concurrency.example.syncContainer;

import com.cc.concurrency.ConcurrencyTest;
import com.cc.concurrency.annoations.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by think on 2018.05.24.
 */
public class VectorExample3 {

    //java.util.ConcurrentModificationException
    public static void test1(Vector<Integer> vector){//foreach
        for (Integer i : vector){
            if (i.equals(3)){
                vector.remove(i);
            }
        }
    }
    //java.util.ConcurrentModificationException
    public static void test2(Vector<Integer> vector){
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if (i.equals(3)){
                vector.remove(i);
            }
        }
    }
    //成功
    public static void test3(Vector<Integer> vector){
        for (int i = 0;i < vector.size(); i++){
            if (vector.get(i).equals(3)){
                vector.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test1(vector);
    }
}

