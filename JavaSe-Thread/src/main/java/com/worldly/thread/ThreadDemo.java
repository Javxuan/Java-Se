package com.worldly.thread;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 守护线程
 *
 * @author Worldly
 * @create 2017-04-15 9:33
 **/
public class ThreadDemo {

    public static void main(String []args) {
        ThreadDemo td = new ThreadDemo();
        CommonThread ct = new CommonThread();
        Thread th = new Thread(ct, "用户线程");
        th.start();

        DemoThread dt = new DemoThread("守护线程");
        dt.setDaemon(true); //要讲此语句放在start()方法之前，不然会报错.
        dt.start();

        /**
         * 如果两线程都是普通线程的话
         * 当用户线程结束之后，另外一个线程也可以正常结束
         *
         * 但从输出的结果来看 当用户线程执行完了，守护线程就被干了。
         */

    }
}

/**
 * 普通线程类(User Thread(用户线程)
 */
class CommonThread implements Runnable{

    public void run(){
        for(int i =0;i<20;i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"第 "+i+" 运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 1. 守护线程  （守护线程--也称“服务线程”，在没有用户线程可服务时会自动离开）
 * 2.守护线程的优先级比较低，用于为系统中的其它对象和线程提供服务。
 * 3.任何一个守护线程都是整个JVM中所有非守护线程的保姆：
 *  只要jvm中还存在任何一个非守护线程实例存在，守护线程就得全部工作
 *  只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作。Daemon的作用是为其他线程的运行提供便利服务
 *
 * 4.守护进程里一般 不要包含输入输出代码，
 *      因为你不确定当你的用户线程结束之后，你的数据是否来得及写入。
 *
 * 5.守护线程并非只有虚拟机内部提供的，可以通过程序 setDemo(true)来设置，但这句话一定要放在 start()之前。
 * 6.不能将正在运行的进程设为守护进程.
 *
 */
class DemoThread extends Thread{
    private String name;
    public DemoThread(String name){
        super(name);
    }
    public void run(){
        for(int i =0;i<20;i++) {
            try {
                Thread.sleep(2000);
                /**
                 * 守护线程里一般禁止 写这种输入输出的代码
                 * 因为你不确定当所有的用户线程跑完了，你的输入输出是否完了，没玩的话。就废了
                 */
                //InputStream in = new FileInputStream("d:\\d.txt");
                System.out.println(Thread.currentThread().getName()+"第 "+i+" 运行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}