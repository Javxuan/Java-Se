package com.worldly.thread;

/**
 * 线程的api测试
 *
 * @author Worldly
 * @create 2017-04-14 17:25
 **/
public class ThreadApi {

    public static void main(String [] args){
        ThreadStart1 ts1 = new ThreadStart1("线程1");
        ts1.start();

        ThreadStart1 ts2 = new ThreadStart1("线程2");
        ts2.start();

        //判断某进程是否被打断
        System.out.println(ts1.isInterrupted());

        //当前线程的堆栈跟踪打印到标准错误流
        //ts1.dumpStack();

        //判断某个线程是否活着
        System.out.println("ts1 线程 状态"+ts1.isAlive());

        /**
         * join(long time)
         *   某个线程等待time毫秒死亡
         *   当time=0的时候表示永远等待
         */
        try {
            ts1.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ts1 线程 状态"+ts1.isAlive());

        //是否为守护线程
        System.out.println("ts1 是否为守护线程 "+ ts1.isDaemon());

    }
}
