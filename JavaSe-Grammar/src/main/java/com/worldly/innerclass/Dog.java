package com.worldly.innerclass;

/**
 * 抽象类
 *
 * @author Worldly
 * @create 2017-04-11 11:16
 **/
public class Dog {
    private String name;

    public Dog(){
        System.out.println("dog父类的构造方法被调用，我的name=="+name);
    }

    public void say(){
        System.out.println("dog父类的构造方法被调用，我的name=="+name);
    }

}
