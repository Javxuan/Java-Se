package com.worldly.classload;

/**
 * 子类
 *
 * @author Worldly
 * @create 2017-04-11 15:45
 **/
public class Child extends Parent{
    private int age;

    static {
        System.out.println("子类的 静态代码块初始化 了");
    }

    {
        System.out.println("子类的普通代码块初始化了");
    }

    public Child(){
        System.out.println("子类的构造方法初始化了");
    }

}
