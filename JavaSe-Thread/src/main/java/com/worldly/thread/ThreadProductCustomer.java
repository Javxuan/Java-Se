package com.worldly.thread;

/**
 * 生产者消费者
 *  思路： 一个生产线程， 一个消费线程，一个生产的对象
 *    生产者生产东西的时候 是给生产对象赋值
 *    消费者消费东西是 取生产对象的值
 *
 *  怎么让生产者与消费者 共享一个资源对象呢。
 *    从外面传一个生产对象订单实例给他
 *
 *  所以消费者和生产者都得有生产对象的属性
 *    可以通过构造方法来接收，也可以通过getter setter方法来搞。
 *
 *
 *
 * @author Worldly
 * @create 2017-04-15 15:57
 **/
public class ThreadProductCustomer {
    public static void main(String []args){
        Food food  = new Food();
        Thread t1 = new Thread(new Customer(food));
        Thread t2 = new Thread(new Producter(food));

        /**
         * 在实际运行的时候 出现下面的情况  说明出现了数据混乱，要加同步。
         *  旺仔小馒头 很老很老的哟
         *  老面馒头 很小很小的哟
         */
        t1.start();
        t2.start();
    }

}

/**
 * 消费者
 */
class Customer implements Runnable{
    private Food food;
    public Customer(Food food){
        this.food=food;
    }

    //实现run()方法
    public void run() {
        for(int i=1;i<=100;i++) {
            synchronized (food) {
                System.out.println(food.getName() + " " + food.getContext() + " 上菜了");
                try {
                    /**
                     * 采用sleep() 有可能出现重复
                     */
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 生产者
 */
class Producter implements Runnable{
    private Food food;

    /**
     * 从外面传food 进来
     * 因为 要共享一个资源
     * @param food
     */
    public Producter(Food food){
        this.food =food;
    }

    //实现run()方法
    public void run(){
        for(int i=1;i<=100;i++){
            /**
             * 在生产的时候，给food设置属性值
             */
            if(i%2==0){
                synchronized (food) {
                    food.setName("旺仔小馒头");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    food.setContext("很小很小的哟");
                }

            }else{
                synchronized(food) {
                    food.setName("老面馒头");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    food.setContext("很老很老的哟");
                }
            }
        }
    }
}

/**
 * 食物
 */
class Food{
    private String name;
    private String context;

    /**
     * 为了避免出现重复出现
     * 定义一个flag
     *   当 flag= true的时候表示可以消费了
     *   否则表示可以生产。
     */
    private boolean flag=true;

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