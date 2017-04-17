package com.worldly.thread;

/**
 * 线程创建的第2种方式
 *
 *  implements Runable 接口  并 实现 run()方法
 *  日常推荐使用。
 *
 * @author Worldly
 * @create 2017-04-14 15:10
 **/
public class ThreadStart2 implements Runnable{
    /**
     * 重写run方法
     *  这里放共享资源访问代码
     */
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " -开启了");
    }

    public static void main(String [] args){
        ThreadStart2 ts2 = new ThreadStart2();
        /**
         * Thread(Runnable target));
         * 让类实现Runable接口，并重写其run()方法
         *  1.多个线程处理同一个资源目标对象
         *  2.
         */
        Thread th1 = new Thread(ts2,"线程1");
        th1.start();

        Thread th2 = new Thread(ts2,"线程2");
        th2.start();

    }
}
