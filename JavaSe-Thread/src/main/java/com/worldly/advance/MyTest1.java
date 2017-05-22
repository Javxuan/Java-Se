package com.worldly.advance;

/**
 * @author Worldly
 * @create 2017-04-21 16:50
 **/
public class MyTest1 implements Runnable{
    static String [] strs=null;
    public static void main(String []args){
        MyTest1 myTest1 = new MyTest1();
        Thread thread = new Thread(myTest1,"a");
        Thread thread1 = new Thread(myTest1,"b");
        Thread thread2 = new Thread(myTest1,"c");
        Thread thread3 = new Thread(myTest1,"d");
        strs= new String[16];

        for(int i=0;i<16;i++){  //这行代码不能改动
            final String log = ""+(i+1);//这行代码不能改动
            strs[i]=log;
        }
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void run() {
      if(Thread.currentThread().getName().equals("a")){
        for(int i=1;i<=4;i++){
            parseLog(strs[i-1]);
        }
      }else if(Thread.currentThread().getName().equals("b")){
            for(int i=5;i<=8;i++){
                parseLog(strs[i-1]);
            }
      }else if(Thread.currentThread().getName().equals("c")){
          for(int i=9;i<=12;i++){
              parseLog(strs[i-1]);
          }
      }else if(Thread.currentThread().getName().equals("d")){
          for(int i=13;i<=16;i++){
              parseLog(strs[i-1]);
          }
      }
    }

    //parseLog方法内部的代码不能改动
    public static void parseLog(String log){
        System.out.println(log+":"+(System.currentTimeMillis()/1000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
