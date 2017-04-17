package com.worldly.keywords;

/**
 * static的关键字
 *  static 修饰的特点
 *      1.static修饰的成员 随着类的加载而存在，不用依赖对象
 *      2.static不能出现this 和super
 *      3.static 在内存中是在方法区域开辟
 * @author Worldly
 * @create 2017-04-11 14:32
 **/
public class StaticKeyWord {
    private static String name ;
    private int age;

    public void say(){
        //非静态的既可以调用静态的也可以调用非静态的
        System.out.println("我是static关键字 name="+name+"  age="+age);
    }

    public static void sayAge(){
        //System.out.println("static修饰的方法只能调用 static修饰的属性 age"+ age);
        //静态的方法和变量又称为类变量，可以只使用 类名 StaticKeyWord调方法名或者属性
        System.out.println("static修饰的方法只能调用 static修饰的属性 name"+ name);
    }

    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        StaticKeyWord.name = name;
    }

    //==============static 的关键字==============

    public static void main(String [] args){
        StaticKeyWord  skw = new StaticKeyWord();
        skw.setName("static");
        skw.say();
    }
}
