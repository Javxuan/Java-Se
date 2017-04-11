package com.worldly.innerclass;

import static javafx.scene.input.KeyCode.M;

/**
 * 成员内部类
 *  1. 成员内部类 和普通的成员变量，成员方法类似
 *  2. 因为是成员内部类，所以可以调用任何成员变量。
 * @author Worldly
 * @create 2017-04-11 10:03
 **/
public class MemberInnerClass {
    private String name;
    private int age;

    public MemberInnerClass(){
        System.out.println("调用外部类的构造方法");
        this.name = name;
    }

    /**
     * 外部类定义该方法 实例化内部类对象
     */
    public void initDog(){
        Dog dog = new Dog();
        dog.sayHell0();
    }

    /**
     * 成员内部类
     */
    class Dog{
        private String name;

        public Dog(){
            System.out.println("调用内部类的构造方法");
            this.name = name;
        }

        public void sayHell0(){
            System.out.println("内部成员类 调用 sayHello 方法");
            System.out.println("我的name是 ="+name); //因为 是成员内部类所以 内部类可以调用外部类的任何成员
        }


    }

    public String getName() {
        return name;
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


    //===========================成员内部类实例化方式============================

    public static void main(String [] args){
        // 1.通过外部类的对象了来实例 内部类 （一般 不这样用）
            //成员都是依赖于类的对象而存在的 所以要先有外部类的对象
            MemberInnerClass mic = new MemberInnerClass();
            //声明内部类对象
            MemberInnerClass.Dog dog = null;
            //实例化内部类对象
            dog= mic.new Dog();
            dog.sayHell0();

        // 2.通过外部类里的一个方法 来实例化 内部类 (常用方法);
            mic.initDog();

    }
}
