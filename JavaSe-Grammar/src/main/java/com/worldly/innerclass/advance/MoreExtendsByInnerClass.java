package com.worldly.innerclass.advance;

/**
 * 通过内部类 改变 Java  只支持单继承的局限性。
 * @author xiaoqixuan
 * @create 2017/5/26 10:39
 */
public class MoreExtendsByInnerClass {
    public static void main(String []args){
        C c = new C();
        //通过内部类来 继承 A 类  从而 获得A相关方法和属性
        c.getInner().sell();
        //通过直接 继承 B类   从而获得B相关的方法和属性
        c.buy();
    }
}

class A1{
    private int num;

    public A1(){
        System.out.println("A1 init ");
    }

    public void sell(){
        System.out.println("A1 sell method ");
    }
}

class B {
    public B(){
        System.out.println("B init");
    }

    public void buy(){
        System.out.println("B buy method");
    }
}

/**
 * 因为Java只支持单继承
 *    所以可以才用内部类来实现多继承。
 */
class C extends B{
    //内部类 extends A 使得 C对象 也可以调用 A里面的方法。
    class Inner extends A1{
    }

    public Inner getInner(){
        return new Inner();
    }
}