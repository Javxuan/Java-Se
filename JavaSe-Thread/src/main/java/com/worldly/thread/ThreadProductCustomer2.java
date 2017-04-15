package com.worldly.thread;

/**
 * 生产者消费者的第2种形式
 *
 * @author Worldly
 * @create 2017-04-15 17:50
 **/
public class ThreadProductCustomer2 {

    public static void main(String [] args){
        Food2 food  = new Food2();
        Thread t1 = new Thread(new Customer2(food));
        Thread t2 = new Thread(new Producter2(food));

        t1.start();
        t2.start();
    }

}

/**
 * 消费者
 */
class Customer2 implements Runnable{
    private Food2 food;
    public Customer2(Food2 food){
        this.food=food;
    }

    //实现run()方法
    public void run() {
        for(int i=1;i<=100;i++) {
            food.get();
        }
    }
}

/**
 * 生产者
 */
class Producter2 implements Runnable{
    private Food2 food;

    /**
     * 从外面传food 进来
     * 因为 要共享一个资源
     * @param food
     */
    public Producter2(Food2 food){
        this.food =food;
    }

    //实现run()方法
    public void run(){
        for(int i=1;i<=100;i++){
            /**
             * 在生产的时候，给food设置属性值
             */
            if(i%2==0){
                food.set("老面馒头","很老很老的哟");
            }else{
                food.set("旺仔小馒头","很小很小的哟");
            }
        }
    }
}

/**
 * 食物
 */
class Food2 {
    private String name;
    private String context;

    /**
     * 为了避免出现重复出现
     * 定义一个flag
     * 当 flag= true的时候表示可以消费了
     * 否则表示可以生产。
     */
    private boolean flag = true;

    /**
     * 将生产食品的方法 设置到food里
     * @param name
     * @param context
     */
    public synchronized void set(String name,String context){


        if(isFlag()){
            try {
                /**
                 * flag 为true的时候表示food已经存在了，不可以生产只能消费
                 *
                 * 所以调用 wait()方法来让当前线程进行等待
                 *    1. 当前线程让出cpu，
                 *    2. 当前线程是否对象锁。
                 *    3. 如果没设置等待时间则需其他线程来唤醒。
                 */
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.setName(name);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setContext(context);

        //当生产好了以后，就通知消费者进行消费。
        flag = true;
        this.notify();

    }

    /**
     * 消费 方法
     */
    public synchronized void get(){

        /**
         * 当已经生产好了food的条件下
         * 就让消费者消费。
         */
        if(!isFlag()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+" "+this.getContext()+" 上菜了");

        /**
         * 当消费完了就将flag标志设置一下
         * 通知生产者接着生产。
         */
        flag=false;
        this.notify();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
