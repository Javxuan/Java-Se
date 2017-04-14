package com.worldly.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * hashMap的api
 * 1.底层是 用hash表实现的
 * 2.可以允许 null key与 null value
 * 3.线程不同步
 * 4.不保证顺序永恒不变(因为hash表扩容的时候，会对所有对象进行重新散列， old %16  new %16*n
 *          所以对象在hash表中存储的位置不一样)
 * 5.
 *
 * @author Worldly
 * @create 2017-04-13 10:31
 **/
public class HashMapApi {

    public void hashMap(){
        Map<Integer,String> map = new HashMap<Integer,String>();

        /**
         * 1.底层实现是通过 hash表和链表实现的
         * 2.hash表是通过对象数组实现的。数组里存的对象(entry)是通过链表实现的
         * 3.存的时候通过 hash值来再hash表里面进行存储。 而hash = 对象的key.hashCode()%16
         * 4.当出现同一个hash有两个对象的时候， 这些对象以链表的形式存在。
         * 5.当存储达到75%的时候，会自动进行扩容。
         * 6.而扩容的时候每个对象的 hash = key.hashCode()%16*n 而重新计算，所以是无序的
         *
         * 7.优点：利用hash表结构来存的会能提高查询效率，先根据 key的hash值查出对象在hash表的那个位置，然后在遍历链表。
         *    比如有100个元素：链表有10个最多只要查10 次就可以了
         *                     而数组的最多要遍历100次
         *   缺点：
         *        hash表在散列的时候要花费很大。
         */
        map.put(1,"空空");
        map.put(2,"兰兰");




    }

}
