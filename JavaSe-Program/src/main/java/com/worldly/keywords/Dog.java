package com.worldly.keywords;

/**
 * 父类
 *
 * @author Worldly
 * @create 2017-04-11 11:52
 **/
public class Dog {
    private String name ;

    public Dog(){
        this("狗祖宗"); //this调用构造方法的时候，必须放在第一行
    }

    public Dog(String name ){
        System.out.println("dog类 带参的构造方法被调用了"+name);
    }

}
