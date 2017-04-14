package com.worldly.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * list特有迭代器api
 *
 * @author Worldly
 * @create 2017-04-12 16:42
 **/
public class ListIteratorApi {
    public static void main(String [] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("0");

        /**
         * listIterator()是 成员内部类实例化的一个方法
         * 成员内部类实例化有两种方式：
         *     1.借助外部类对象 OutClass out = new OutClass(); OutClass.InnerClass  outI = out.new InnerClass();
         *     2.在外部类里面放建一个方法，里面包含实例化内部类代码； 如 iterator(){ return  new Iterator()}
         *     第2种方式比较常用
         *    3.listerIterator extends Iterator接口里面
         *    有 hasNext() ,next() 等方法， 还额添加了几个方法
         */
        ListIterator iterator = list.listIterator();
        show(list);
    }

    private static void show(List list) {
            ListIterator it = list.listIterator();

            while(it.hasNext()) {
                if(it.hasPrevious()){
                    System.out.print("前面有元素 ");
                }
                System.out.println(it.next());
            }
    }
}

