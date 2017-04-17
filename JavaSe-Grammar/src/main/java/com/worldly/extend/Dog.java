package com.worldly.extend;

/**
 * 狗的父类
 *
 * @author Worldly
 * @create 2017-04-11 8:48
 **/
public class Dog {

    private String name="狗";
    private int age;

    //声明了带参的构造函数，无参的构造函数就不存在了，要的化则要显示声明；
    public Dog(String name){
        System.out.println("父类的构造方法 被调用了");
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void sayHello() {
        System.out.println("这一只狗 名字为 =" + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
