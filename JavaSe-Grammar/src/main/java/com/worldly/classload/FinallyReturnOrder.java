package com.worldly.classload;

/**
 * 异常处理是finally与return的顺序
 *
 * @author Worldly
 * @create 2017-04-11 15:41
 **/
public class FinallyReturnOrder {

    public int test1(int i){
        try {
            i = i/1;
            System.out.println("try 的return 执行了，i="+i);
            return i; //采用return结束该方法，但是 finally里面还是会执行的。
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 执行了，i="+i);
            i=i+10;
            return i; //finally最后执行的 如果有return 值 会把try里的return值 覆盖掉。
        }
    }

    public int test2(int i){
        try {
            i = i/1;
            System.out.println("try 的return 执行了，i="+i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i=i+10;
            System.out.println("finally 执行了，i="+i);
        }
        return 0; //finally是最后执行的，所以该语句无效。
    }

    public static void main(String []args){
        int i=10;
        int result =  new FinallyReturnOrder().test1(i);
        System.out.println(result);

        int result1 =  new FinallyReturnOrder().test2(i);
        System.out.println(result1);

    }

}
