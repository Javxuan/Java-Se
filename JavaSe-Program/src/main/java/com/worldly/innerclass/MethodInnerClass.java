package com.worldly.innerclass;

/**
 * 方法内部类
 *
 * @author Worldly
 * @create 2017-04-11 10:26
 **/
public class MethodInnerClass {

    private String name ;

    public MethodInnerClass(){
        System.out.println("外部类构造方法被调用");
    }

    public void sayHello(){
        System.out.println("外部类，我的name ="+name);
    }

    /**
     * 方法内部类
     */
    public void catSay(){
        final int age =0;
        class Cat{
            public Cat(){
                System.out.println("方法内部类构造函数被调用");
            }

            public void say(){ //因为catSay()为MethodInnerClass的成员方法，可以调用任意的成员变量name
                                // 但是只能调用该内部类所在方法的局部常量 age
                System.out.println("内部类，我的name = "+name+" age="+age);
            }
        }
        //实例化只能在 该方法内部实例化 不能在方法外实例化。 因为该内部类的作用域只是该方法
        Cat cat = new Cat();
        cat.say();
    }

    public static void main(String [] args){
        MethodInnerClass mic  = new MethodInnerClass();
        mic.catSay();
    }
}
