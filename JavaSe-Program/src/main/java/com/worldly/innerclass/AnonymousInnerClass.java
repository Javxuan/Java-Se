package com.worldly.innerclass;

/**
 * 匿名内部类
 *  1.接口式匿名内部类
 *  2.继承式匿名内部类
 *  3.参数式匿名内部类
 *
 * @author Worldly
 * @create 2017-04-11 11:07
 **/
public class AnonymousInnerClass {
    private String name;


    public void dogSay(Dog dog){
        dog.say();
    }


    public static void main(String [] args){
        //接口式匿名内部类
        A a = new A() { //{}相当于 A的实现类
            public void say() {
                System.out.println("接口式匿名内部类---我是A接口的实现类");
            }
        };
        a.say();

        //继承式匿名内部类
        Dog dog = new Dog(){
          public void say(){
              System.out.println("继承式匿名内部类 ---dog 的子类 ");
          }
        };
        dog.say();

        //参数式匿名内部类
        AnonymousInnerClass aic = new AnonymousInnerClass();
        aic.dogSay(new Dog(){
            public void say(){
                System.out.println("我是参数式匿名内部类--dog的子类");
            }
        });


    }


}
