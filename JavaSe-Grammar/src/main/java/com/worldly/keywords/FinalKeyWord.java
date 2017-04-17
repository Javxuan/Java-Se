package com.worldly.keywords;

/**
 * final关键字
 * 1.被final修饰的变量或者属性，不可以进行二次赋值。
 *      如果是基本数据类型的化值不可以改变，如果是引用类型的化引用地址不可以改变
 * 2.final修饰的类不可以被继承
 * 3.final修饰的方法不可以被重写
 * 4.final修饰的变量 是在堆内存中的常量内存里
 * @author Worldly
 * @create 2017-04-11 15:00
 **/
public class FinalKeyWord extends Cat{

    private final String name="final";

    public FinalKeyWord(){
        super();
    }

    public FinalKeyWord(String name){
        super("parent");
    }

    public static void main(String [] args){
        FinalKeyWord fkw = new FinalKeyWord();
        fkw.say();
        FinalKeyWord fkw2 = new FinalKeyWord("child");
        fkw.say();

    }

}
