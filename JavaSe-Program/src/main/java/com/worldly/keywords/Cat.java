package com.worldly.keywords;

/**
 * 测试final的
 *
 * @author Worldly
 * @create 2017-04-11 15:07
 **/
public class Cat {
    private final String name="123";
    private final int age=0;

    public Cat(){
        System.out.println("用final修饰的变量，name="+name);
    }

    public Cat(String name){
        System.out.println("用final修饰的变量，name="+name);
    }

    public void say(){
        System.out.println("我是父类cat， name=="+name);
    }

}
