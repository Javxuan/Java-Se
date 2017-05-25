package com.worldly.arrays;

/**
 * 二维数组的相关语法
 * 二维数组的init
 * @author xiaoqixuan
 * @create 2017/5/25 14:52
 */
public class TwoArrayInit {
    public static void main(String []args){

        /***
         * 二维数组的第一种创建方式 :动态初始化
         *  先初始化一维数组
         * int [][] arr = new int [10][];
         * 如果要使用二维数组里面的元素，就要初始化二维数组，否则会报NUllPointedException
         */

        int [][] arr = new int [10][];
        //遍历一维数组
        for(int x=0;x<arr.length;x++){
            //根据一维数组确定数组的行，然后初始化有多少列，列数可以不一样(初始化二维数组)
            arr[x] = new int[x+1];
            for(int y=0;y<arr[x].length;y++){
                if(x==0||y==0||x==y)
                    arr[x][y]=1;
            }
        }
        show(arr);
        System.out.println("====================================");

        /**
         * 二维数组的第二种创建方式  静态初始化
         * 一开始声明二维数组的时候就把行和列 都初始化了。
         * int [][] arr2 = new int [5][3];
         */

        int [][] arr2 = new int [5][3];
        for(int x=0;x<arr2.length;x++){
            for(int y=0;y<arr2[x].length;y++){
                if(x==0||y==0||x==y)
                    arr2[x][y]=1;
            }
        }
        show(arr2);
        System.out.println("====================================");

        /**
         * 二维数组的第三种创建方式   静态初始化
         * int [][] arr3 = {{},{},{}};  《==》 arr3=new int[3][];
         * 一开始声明的时候就给元素赋值。
         */
        int [][] arr3 = {{},{},{}};

        //未对二维数组的列进行初始化所以 arr3[0][0]位置在内存中没有分配内存，没有引用。
        //System.out.println("arr3.length="+arr3.length+" arr3[0][0]="+arr3[0][0]);
        System.out.println("arr3.length="+arr3.length+" arr3[0].length="+ arr3[0].length);
        show(arr3);

        /**
         * 二维数组的第三种创建方式  静态初始化
         * int  arr3 = new int[][]{{1,2,3},{4,5},{6}};
         * 定义数组的时候直接初始化给相应的元素进行赋值。
         */
        arr3 = new int[][]{{1,2,3},{4,5},{6}};
        show(arr3);
        System.out.println("====================================");

    }

    public static void show(int [][] arr ){
        for(int x=0;x<arr.length;x++){
            for(int y=0;y<arr[x].length;y++){
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
    }
}
