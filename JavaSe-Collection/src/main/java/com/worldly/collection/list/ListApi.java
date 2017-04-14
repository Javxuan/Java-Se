package com.worldly.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * list接口api测试
 *   1.list集合的特点
 *      有序，
 *      可重复，
 *      有下标索引值，
 *      可以 包含多个null的值
 *   2.子类
 *     verctor 自动扩充的时为原来的2倍，或者指定扩充容量大小 用动态数组实现的 线程安全的
 *     arrayList （oldSize*3）/2+1 ， 用动态数组实现的     线程不安全的  select效率高
 *     linkedList    线程不安全的  用双向链表实现的  增删效率高
 * @author Worldly
 * @create 2017-04-12 15:27
 **/
public class ListApi {

    public static void main(String [] args){
        //用ArrayList去实例化
        List list = new ArrayList();

        //add(Object)  当添加成功，发生变化的时候就返回true
        boolean a = list.add(1);
        boolean b =list.add(1);
        System.out.println("a ="+a+" b="+b);

        //指定位置添加，原来的有元素就往右移，没有就算了
        list.add(1,"a");
        System.out.println(list.size()+"=="+list.get(1));

        List list1 = new ArrayList();
        list.add("b");
        list.add("b");
        list.add("c");
        show(list1);


        //添加整个集合
        System.out.println("添加整个集合");
        boolean  f= list.addAll(list1);
       // System.out.println(list.size()+" = "+f);
        show(list);

        // 移除某个元素
        System.out.println();
        //list.remove(2);
        System.out.println("移除某个元素");
        System.out.println(list.size() +"移除某个元素 后list");
        show(list);

        //截取list里面的元素，数字集合从1 开始
        System.out.println();
        System.out.println("截取list里面的元素，数字集合从1 开始");
        List list2 = list.subList(1,4);
        System.out.println(list.size()+"list2");
        show(list2);

        /**
         * 保留此集合元素在指定集合元素相同的元素。
         * list 1 a 1 b b c
         * list2 a 1 b
         * 调用后  1 a 1 b b
         */
        System.out.println();
        System.out.println("取两个集合的交集");
        boolean b2 = list.retainAll(list2);
        System.out.println(""+b2+" list");
        show(list);

    }

    /**
     * 遍历集合
     * @param list
     */
    private static void show(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
    }
}
