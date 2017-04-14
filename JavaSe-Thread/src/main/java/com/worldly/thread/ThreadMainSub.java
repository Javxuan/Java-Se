package com.worldly.thread;

/**
 * 测试主线程和子线程
 *
 * @author Worldly
 * @create 2017-04-14 16:08
 **/
public class ThreadMainSub extends Thread{

    public void run(){
        for(int i = 0; i <= 5; i++) {
            try {
                System.out.println(currentThread().getName() + "---" + i);
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args) {
        /**
         * 1，当你运行这个类的时候，首先是java虚拟机自动创建一个线程,假设为T1,
         这个线程会调用main方法，main方法是java虚拟机自动调用的，调用的这个线程，
         即通常我们说的   主线程

         2，ThreadMainSub 是你自定义的一个线程，
         当T1线程调用t.start();的时候，此时就启动了线程ThreadMainSub，T1线程只是告诉线程ThreadMainSub，啊，我通知一下，你可以运行了。
         我还有工作没做完，我先走了，
         ThreadMainSub这个线程运行后， 会自动调用run方法，所以run方法是在threadDemo线程中运行的，
         System.out.println(currentThread().getName() + "---" + i);打印的是ThreadMainSub 线程

         3，T1线程通知ThreadMainSub可以运行以后，他就不管ThreadMainSub了，调用t.start()后，
         会立即执行下面的代码t.run，因为t.run的调用与普通方法没有任何区别，
         t.run与t.start不一样，因为java规范规定start启动一个线程，但没规定run方法启动一个线程
         那么既然run方法没有启动新的线程，那么t.run();方法还是在T1线程中运行的
         所以t.run();是打印的是main线程
         */
        ThreadMainSub t = new ThreadMainSub();

        /**
         * 因为调用了start()方法，表示有一个线程对象存在，但还没创建一个线程，
         * 当获得执行权的时候，jvm 就会创建该线程 如 Thread-0，
         * 当线程创建之后调用run()方法，所以run()是在该线程里执行的
         */
        t.start();

        /**
         * 因为直接调用run()方法，和普通方法差不多，没有启动新的线程。所以t.run()还是在一开始运行main()的主线程了
         *  所以打印的是main线程信息
         */
        t.run();


    }
}
