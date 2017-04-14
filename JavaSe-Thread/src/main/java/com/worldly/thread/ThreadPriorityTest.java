package com.worldly.thread;

/**
 * 设置线程的优先级
 *
 * @author Worldly
 * @create 2017-04-14 16:38
 **/
public class ThreadPriorityTest {

    public static void main(String []args){
        //showNormal();

        showNormal2();
    }

    /**
     * 正常的没有设置优先级
     * 正常的优先级默认为5
     */
    public static void showNormal(){
        ThreadStart1 ts1 = new ThreadStart1("线程1");
        ts1.start();

        ThreadStart1 ts2 = new ThreadStart1("线程2");
        ts2.start();

        System.out.println("线程ts1的是否"+ts1.isInterrupted());
    }

    /**
     * 通过setPriority()来设置优先级
     *  优先级只是代表线程获取cpu的时间片的几率较高，并不一定就会想按照优先级来的
     * 优先级最低的为 1
     *       正常的为 5
     *       最高的为10
     * 可以通过设置来设置
     */
    public static void showNormal2(){

        /**
         * 主线程调用 main 函数
         * 然后执行 showNormal2()方法
         * 启动了两个子线程，
         * 执行打印语句
         * 子线程获取cpu时间片之后运行run()方法
         */
        ThreadStart1 ts1 = new ThreadStart1("线程3");
        ts1.start();


        ThreadStart1 ts2 = new ThreadStart1("线程4");
        ts2.start();
        ts2.setPriority(10);

        //主线程的优先级
        System.out.println("线程ts3的是否"+ts1.isInterrupted());
    }
}
