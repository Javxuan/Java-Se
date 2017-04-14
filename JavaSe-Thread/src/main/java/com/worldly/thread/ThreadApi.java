package com.worldly.thread;

/**
 * 线程的api测试
 *  比较重要的方法
 *
 *
 *  让当前线程 休眠 几秒
 *  sleep(long time) 方法   然其他线程也可以执行，cpu时间片轮转
 *
 *
 *  //等待当前线程几秒   0的话就一直在等待
 *  join(long time) 方法    在实际应用中必须等待某个线程结束后返回的结果。
 *                          炒饭：只能先等电饭煲里的饭好了
 *                                才能炒
 *  isInterrupt()是否打断
 *
 *  demo线程
 *
 *  yield()
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
        //守护线程必须依赖于用户线程而存在
        System.out.println("ts1 是否为守护线程 "+ ts1.isDaemon());

    }
}
