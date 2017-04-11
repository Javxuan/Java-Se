package com.worldly.extend;

/**
 * 家狗
 *
 * @author Worldly
 * @create 2017-04-11 8:50
 **/
public class HomeDog extends Dog{
    private String name ;

    public HomeDog(){
        super("parent"); //如果父类没有参数为空的构造参数，子类则要显示指定调用的父类的构造方法
        System.out.println("子类的构造方法 被调用了");
        this.name =name;
    }

    public void sayHello(){
        System.out.println("子类有和父类同名的方法，子类的名字="+name); //只要是成员变量在该类的任何地方都可以调用
    }

    public static void main(String [] args){
        HomeDog homeDog = new HomeDog();
        homeDog.setName("家狗");

        //如果父类与子类都有相同名字的方法名的话， 调用的是子类的方法
        homeDog.sayHello();


    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
