package com.worldly.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器的api
 * 为什么要用iterator :1. 迭代器统一了遍历集合的情况
 *                     2. iterator　是一个接口，
 * @author Worldly
 * @create 2017-04-12 16:48
 **/
public class IteratorApi {
    public static void main(String [] args){
        List list = new ArrayList();
        list.add("a");
        list.add("1");
        list.add("b");
        list.add("2");
        list.add("c");

        //不使用迭代器的化
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        /**
         * listIterator()是 成员内部类实例化的一个方法
         * 成员内部类实例化有两种方式：
         *     1.借助外部类对象 OutClass out = new OutClass(); OutClass.InnerClass  outI = out.new InnerClass();
         *     2.在外部类里面放建一个方法，里面包含实例化内部类代码； 如 iterator(){ return  new Iterator()}
         *     第2种方式比较常用
         *    Iterator接口里 有 hasNext() ,next() 等方法， 还额添加了几个方法
         */
        Iterator it = list.iterator();

        System.out.println("\n"+"采用 iterator遍历元素");
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

    }

}
