package com.worldly.innerclass;

/**
 * 静态内部类
 *
 * @author Worldly
 * @create 2017-04-11 10:50
 **/
public class StaticInnerClass {
    private static  String name="外部内类的static 成员" ;

    public StaticInnerClass(){
        System.out.println("外部类的构造方法被调用");
    }

    /**
     * 静态内部类pig
     */
    static class Pig{
        private int age;
        public Pig(){
                   //该成员方法只能调用 外部类static 的成员 name
            System.out.println("静态内部类的构造方法被调用  name="+name +" age="+ age);
        }
    }

    //静态内部类实例化方法
    public static void main(String []args){
        //静态内部类不用依赖于外部类对象而存在可以直接用 外部类.静态成员来实例化
        StaticInnerClass.Pig  pig= new StaticInnerClass.Pig();
    }



}
