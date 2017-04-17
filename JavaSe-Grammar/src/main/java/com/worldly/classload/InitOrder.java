package com.worldly.classload;

/**
 * 类每个部分初始化的顺序
 * 1.先是父类静态代码块初始化
 * 2子类静态代码块初始化
 * 3.然后是父类的普通代码块
 * 4.再是父类的构造方法
 * 5.再是子类的普通代码块
 * 6.再是子类的构造方法
 * @author Worldly
 * @create 2017-04-11 15:40
 **/
public class InitOrder {

    public static void main(String [] args){
        Child c =new Child();
    }
}
