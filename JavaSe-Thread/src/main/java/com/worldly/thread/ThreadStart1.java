package com.worldly.thread;

/**
 * 创建线程方式1
 *   extends  Thread   重写 run()方法
 *   如果确定该类只需要extends Thread 就可以使用
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
        try {
            /**
             * Thread.sleep() 在哪个线程内，就表示哪个线程会进入休眠状态
             *
             * 1.线程 sleep(time)方法是，让当前线程进入一个休眠状态，
             * 休眠 time 时间，让出时间片个其他线程执行
             * 当time完了，该线程就恢复了。
             *
             * 2.虽然把时间片让出来了，但是保留着该资源的监控权，
             *   必须该进程执行完后，才会释放资源的监控权（另外一个线程不使用该资源）
             */
            Thread.sleep(1000);
            System.out.println(this.getName()+"  ==开启了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String []args){
        /**
         * 多线程创建：
         *  0.每个进程最少有一个线程(main线程)
         *  1.不管这个线程初始化的顺序是怎样的，都是先把线程初始化
         *  2.然后根据优先级来 开启线程。
         *  3.由于下面两个线程都是并行的线程，所以执行顺序不确定
         *
         */

        //创建一个线程
        ThreadStart1 ts1 = new ThreadStart1("线程1");
        ts1.setPriority(3);
        //告诉cpu 该线程已经准备好了，可以执行了。
        ts1.start();

        ThreadStart1 ts2 = new ThreadStart1("线程2");
        ts2.setPriority(5);
        ts2.start();

        System.out.println(ts2.interrupted());


    }

}
