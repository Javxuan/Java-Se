package com.worldly.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * set的api
 *  1.set 集合的特点：
 *      无序，
 *      不重复，
 *      无下标索引值，
 *      最多包含一个null的元素
 *  2.子类
 *     hashSet  有hash表来实现的 (底层还是用的hashMap) 默认初始容量也为16
 *     TreeSet
 * @author Worldly
 * @create 2017-04-12 19:06
 **/
public class SetApi {

    public static void main(String [] args){
        // ====================================HashSet========================
        /**
         * hashSet  有hash表来实现的 (底层还是用的hashMap)
         *   默认初始容量也为16
         */

        Set set = new HashSet();
        set.add("1");
        set.add("a");
        set.add("b");
        set.add(0);

        //add
        //show(set);

        /**
         * 添加同一元数的时候，添加不了
         * 这就是 不重复，
         * 判断是否重复：
         *   1.根据元素的hashCode来判断是否相同
         *   2.如果hashCode也相同就通过 equals()方法来判断
         */
        set.add("b");
        show(set);

        //set没有下标索引，所以不能通过index来获取
        //其他方法和list的都差不多


        // ====================================TreeSet========================
        /**
         * TreeSet 1.使用元素的自然排序来 让集合有序
         *         2.底层用TreeMap的实现
         *      3.当添加自定义对象的时候，对象要实现comparable<Object>接口，并重写比较规则；
         */
        TreeSet<Cat> ts = new TreeSet<Cat>();

        ts.add(new Cat("a",1));
        ts.add(new Cat("b",2));
        System.out.println(ts.size());

        ts.add(new Cat("b",2));
        System.out.println(ts.size());

    }

    private static void show(Set set){
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }

}
