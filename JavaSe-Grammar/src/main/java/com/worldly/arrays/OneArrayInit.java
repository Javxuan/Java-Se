package com.worldly.arrays;

/**
 * 一维数组初始化
 * @author xiaoqixuan
 * @create 2017/5/25 15:30
 */
public class OneArrayInit {
    public static void main(String []args){
        /**
         * 一维数组第一种初始化方式  动态初始化
         */
        int [] arr = new int[5];
        show(arr);
        System.out.println("\n"+"====================");

        /**
         * 一维数组第二种初始化方式  静态初始化
         */
        int [] arr2 = {};
        System.out.println(arr2.length);
        show(arr2);
        System.out.println("\n"+"====================");


        int [] arr3 = {1,2,3,4,1,2,1};
        System.out.println(arr2.length);
        show(arr3);


    }

    public static void show(int []arr ){
        for(int x=0;x<arr.length;x++){
            System.out.print(arr[x]+" ");
        }
    }
}
