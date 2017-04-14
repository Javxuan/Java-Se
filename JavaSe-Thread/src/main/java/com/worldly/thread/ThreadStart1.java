package com.worldly.thread;

/**
 * 创建线程方式1
 *
 * @author Worldly
 * @create 2017-04-14 12:00
 **/
public class ThreadStart1 extends Thread{

    private String name;  //与父类的name属性相同，
    public ThreadStart1(String name){
        super(name);   //没有显示的指明要调用父类的那个构造方法会默认的 super()；
    }

    public void run(){  //因为getName()方法是final，子类不能重写，调用的是父类Thread的方法，
                         //而父类的
        System.out.println(this.getName()+"  ==开启了");
    }

    public static void main(String []args){
        /**
         * 多线程创建：
         *  1.不管这个线程初始化的顺序是怎样的，都是先把线程初始化
         *  2.然后根据优先级来 开启线程。
         *  3.由于下面两个线程都是并行的线程，所以执行顺序不确定
         *
         */

        ThreadStart1 ts1 = new ThreadStart1("线程1");
        ts1.setPriority(3);
        ts1.start();

        ThreadStart1 ts2 = new ThreadStart1("线程2");
        ts2.setPriority(5);
        ts2.start();

        System.out.println(ts2.interrupted());


    }

}
