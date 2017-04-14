package com.worldly.collection.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * hashTable
 *  1.与hashMap 差不多
 *  2.不允许key 为null 和 value 为null
 *  3. 初始化的是大小为11， 加载因子为0.75
 *  4.跟Object一样是jdk同一批出现的。
 *  5.线程安全的
 *
 * @author Worldly
 * @create 2017-04-13 19:14
 **/
public class HashTableApi {

    public void hashTable(){
        Map<Integer,String> map = new Hashtable<Integer,String>();

    }
}
