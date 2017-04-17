package com.worldly.thread;

/**
 * 理解 sleep() 和join()这两个方法
 *
 * @author Worldly
 * @create 2017-04-14 21:08
 **/
public class ThreadJoinSleep implements  Runnable{
    //实现run方法
    public void run() {
        for(int i=0;i<5;i++){
            try {
                /**
                 * sleep(long time)
                 * 表示当前线程休眠time 毫秒
                 * 当前线程是指 Thread.sleep()在哪个线程里就只 哪个线程， 比如
                 * 现在就指 ThreadJoin这个线程
                 */
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"=="+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    public static void main(String []args){
        ThreadJoinSleep tj = new ThreadJoinSleep();
        Thread th = new Thread(tj);
        th.start();

        /**
         * join(long time); time为0的时候就是直到该某个线程执行完了再执行
         * 开始的时候因为cpu时间片轮转，所以 主线程和 线程th都是轮换 执行的
         * 当j==2的时候， 主线程就等待 th线程先执行完再 执行。
         */
        for(int j=0;j<3;j++){
            if(j==2){
                try {
                    th.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000); //指的是main线程
                System.out.println(Thread.currentThread().getName()+"--"+j);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


}
