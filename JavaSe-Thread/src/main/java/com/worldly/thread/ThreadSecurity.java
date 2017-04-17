package com.worldly.thread;

/**
 * 线程安全问题
 *
 * @author Worldly
 * @create 2017-04-14 21:37
 **/
public class ThreadSecurity implements  Runnable{

    /**
     * 如果run里面有用到线程之间共享的数据就要用同步来解决
     */
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 拉屎ing");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 拉屎end");
    }

    public static void main(String[]args){
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
        ThreadSecurity ts  = new ThreadSecurity();
        Thread th1 = new Thread(ts,"小白");
        Thread th2 = new Thread(ts,"凤凤");
        th1.start();
        th2.start();
    }
}


