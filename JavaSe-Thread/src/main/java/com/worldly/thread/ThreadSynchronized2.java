package com.worldly.thread;

/**
 * 线程同步方法的测试
 *  同步就是牺牲效率，换的安全
 * @author Worldly
 * @create 2017-04-14 22:20
 **/
public class ThreadSynchronized2 implements  Runnable{
    /**
     * 1.重写run方法
     * 2.在run()调用同步方法
     */
    public  void run() {
        doSomething();
    }

    /**
     * 执行原理：
     *  1.th1 小白， th2凤凤 都要拉屎
     *  2.比如是小白先得到时间片，线程th1运行的时候，小白要拉屎，
     *    就先查看一下obj对象是否上了锁（0表示未上锁，1表示上了锁）；
     *  3.一看obj状态为0 就进去执行同步代码块
     *  4.等执行到Thread.sleep()就休眠，让出cpu时间片。而这时 th2 获得了时间片
     *  5.但去看obj的状态是时 为1,那th2只有等，等到时间片结束了。
     *  6.th1这时又有肯能获得时间片，假如获得了，那接着往下执行。执行完了同步代码开
     *  7.就的得开锁，obj 的状态又变为0 。
     *  8.此时如果th2获得了时间片的话，又去看下obj 的状态，然后再走一遍流程
     *  9.直到所有的结束
     */
    public synchronized  void doSomething(){  // 同步的是当前对象
        System.out.println(Thread.currentThread().getName() + " 拉屎ing");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 拉屎end");
    }

    public static void main(String [] args){
        /**
         * 小白和凤凤共用一个厕所
         * 正常逻辑 小白和凤凤都想拉屎 只能有一个人在拉屎，一个拉完了，另一个人才能拉
         * 而run()里面放的就是共享数据。
         * 如果出现  凤凤 拉屎ing
         小白 拉屎ing
         凤凤 拉屎end
         小白 拉屎end
         就是说明出现了数据冲突，要解决数据冲突就要用到 同步
         */
        ThreadSynchronized2 ts  = new ThreadSynchronized2();
        Thread th1 = new Thread(ts,"小白");
        Thread th2 = new Thread(ts,"凤凤");
        th1.start();
        th2.start();
    }
}
