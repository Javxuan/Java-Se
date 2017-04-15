package com.worldly.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用
 * 线程池可以通过 ExcutorService 提供方法来管理终端和方法
 * 创建各种型号的线程池的时候可以通过 Excutors 类调用各种创建方法来创建。

 * @author Worldly
 * @create 2017-04-15 21:22
 **/
public class ThreadPool {

    public static void main(String []args){


        MyThread my = new MyThread();
        MyThread my2 = new MyThread();
        /**
         *  创建含一个线程的线程池
         *  如果要执行两个任务时，只能分成单个来执行。
         */
        //ExecutorService es  = Executors.newSingleThreadExecutor();

        /**
         * 创建固定大小数量的线程池
         * 如：大小为2
         * 要执行两个任务的时候
         * 这两任务能同时执行
         */
        //ExecutorService es = Executors.newFixedThreadPool(2);

        /**
         * 创建代缓存的线程池
         * 可以智能的根据 执行的任务数来智能的保持线程池中的线程数
         * 如果任务>线程   智能加线程数
         *     任务<线程   智能的销毁线程数
         *
         *  比如有两个执行任务
         *  就一开始就创建两个大小的线程池
         */
        ExecutorService es = Executors.newCachedThreadPool();

        /**
         * 创建一个无限制的线程池
         * 创建执行计划任务的线程池
         *
         * corePoolSize 是在空闲的时候池中药保持的线程数
         */
        //ExecutorService es = Executors.newScheduledThreadPool(2);

        es.execute(my);
        es.execute(my2);

    }
}

class MyThread implements Runnable{
    public void run(){
        for(int i=0;i<10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread-" + i);
        }
    }
}