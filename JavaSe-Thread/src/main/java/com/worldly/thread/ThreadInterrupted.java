package com.worldly.thread;

/**
 * 线程中断的方法
 *
 * @author Worldly
 * @create 2017-04-15 8:49
 **/
public class ThreadInterrupted implements Runnable{
    /**
     * 自定义中断标记
     */
    static boolean flag = false;


    //实现 run()
    public void run() {
        //sleepInterrupted();
        //isInter();
        cusotmInterruped();
    }

    public static void main(String []args){
        ThreadInterrupted ti = new ThreadInterrupted();
        Thread th = new Thread(ti);
        th.start();
        System.out.println("要中断当前线程了");
        //th.interrupt();  //中断当前线程
        //ti.setFlag(true);  //把线程中断标记开启

        System.out.println(Thread.currentThread().getName());
        try {
            /**
             * 当th线程未被中断的话 ，main线程一直都得等待
             * 下面的输出语句是不会允许的。
             *  如果 输出了下面相关的语句就是说明 th线程被中断了
             */
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("线程退出了");


    }

    /**
     * 使用sleep()相当于中断线程多少秒
     */
    public static void sleepInterrupted(){
        try {
            System.out.println(Thread.currentThread().getName()+"运行");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 中断方法1
     * 使用interruped/isInterruped来判断线程是否终止
     * interruped 表示判断当前线程
     * isInterruped 还可以判断其他线程
     */
    public static void isInter(){
        while(!Thread.interrupted()){
            System.out.println(Thread.currentThread().getName()+ "在执行");
        }
    }


    /**
     * 中断方法2
     * 自定义一个中断标记
     */
    public static void cusotmInterruped(){
       while(!flag){
           System.out.println(Thread.currentThread().getName()+"在运行");
       }
    }


    public static boolean isFlag() {
        return flag;
    }
    public static void setFlag(boolean flag) {
        ThreadInterrupted.flag = flag;
    }
}
