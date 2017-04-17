package com.worldly.classload;

/**
 * 父类
 *
 * @author Worldly
 * @create 2017-04-11 15:42
 **/
public class Parent {
    private String name;

    static{
        System.out.println("父类的静态代码块 初始化了");
    }

    {
        System.out.println("父类的普通代码块 初始化了");
    }

    public Parent(){
        System.out.println("父类的构造方法 初始化了");
    }
}
