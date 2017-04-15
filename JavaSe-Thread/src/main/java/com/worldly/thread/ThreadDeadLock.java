package com.worldly.thread;

/**
 * 线程死锁
 *
 * @author Worldly
 * @create 2017-04-15 10:24
 **/
public class ThreadDeadLock extends Thread{
    private boolean flag;
    private DressUp dressUp;
    public ThreadDeadLock(boolean flag,DressUp dressUp){
        this.flag = flag;
        this.dressUp=dressUp;
    }

    public void run() {
        if(this.flag){
            dressUp.jingSuZi();
        }else{
            dressUp.suJingZi();
        }
    }


    public static void main(String []args){
        DressUp dressUp = new DressUp();
        ThreadDeadLock t1 = new ThreadDeadLock(false,dressUp);
        ThreadDeadLock t2 = new ThreadDeadLock(true,dressUp);

        t1.start();
        t2.start();

    }
}


/**
 * 做完某件事，必须要的资源
 * 如果 一个人 打扮 (必须要有镜子和梳子两个资源)
 *   1.镜子。
 *   2.梳子。
 */
class DressUp{
    //镜子
    private Object jingZi=new Object();
    //梳子
    private Object suZi=new Object();

    /**
     * 表示不同线程占用不同的资源
     */
    public void jingSuZi(){
        synchronized (jingZi){
            System.out.println(Thread.currentThread().getName()+" 拿到了镜子");

            synchronized (suZi){
                System.out.println(Thread.currentThread().getName()+"拿到了梳子");
            }
        }
    }

    public void suJingZi(){
        synchronized (suZi){
            System.out.println(Thread.currentThread().getName()+" 拿到了梳子");
            synchronized (jingZi){
                System.out.println(Thread.currentThread().getName()+"拿到了镜子");
            }
        }
    }

}
