package com.worldly.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * set集合里去除重复的元素
 *   set判断元素是否重复：
 *       1.先比较两元素的hashCode值
 *       2.再通过equals()方法来比较两对象是否相同
 *       3.要比较的对象必须同时重写hashCode 和equals(Object obj)方法
 * @author Worldly
 * @create 2017-04-12 19:26
 **/
public class IsSame {
    public static void main(String []args){
        Set<Dog> set = new HashSet<Dog>(2);
        Dog dog1 = new Dog();
        dog1.setName("狗1");
        dog1.setAge(23);

        //add
        boolean a = set.add(dog1);
        System.out.println("add dog1== " + a);

        Dog dog2 = new Dog();
        dog2.setName("狗1");
        dog2.setAge(23);

        // 因为dog2和dog1属于同一个对象，set添加的时候不成功
        boolean b = set.add(dog2);
        System.out.println("add dog2 =" + b);
    }
}
