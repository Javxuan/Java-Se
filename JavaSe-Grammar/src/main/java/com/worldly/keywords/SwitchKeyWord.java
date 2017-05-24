package com.worldly.keywords;

/**
 * switch 语句执行的顺序：
 *  1.先判断有没有 符合要求的case
 *    1.1 如果有case则　从该case 往下 走直至 break 或者是跑完。
 *  2.如果没有符合要求的 case
 *    2.1.则 按顺序由上往下执行 直至break 或者是结束。
 *  
 * @author xiaoqixuan
 * @create 2017/5/24 15:43
 */
public class SwitchKeyWord {
    public static void main(String []args){
        int x=2;

        System.out.println("1============case 可以找到值 但没break  start==============");
        /**
         * 当switch 的条件在 下面有的话 直接定位到 case 2的位置开始往下执行。
         */
        System.out.println("1.1====================default 在case的起前面=======================");
        switch(x){
            default:
                System.out.println("default");
            case 2:
                System.out.println("case 2");
            case 3:
                System.out.println("case 3");
        }
        System.out.println("1.2====================default 在case的后面=======================");

        switch(x){
            case 2:
                System.out.println("case 2");
            case 3:
                System.out.println("case 3");
            default:
                System.out.println("default");
        }
        System.out.println("1============case 可以找到值 但没break  end=============");

        System.out.println("2============case 可以找到值 也有break ==start=============");
        System.out.println("2.1==========default 在case前==================");
        switch(x){
            default:
                System.out.println("default");
            case 2:
                System.out.println("case 2");
                break;
            case 3:
                System.out.println("case 3");
        }
        System.out.println("2.2==========default 在case后==================");
        switch(x){
            case 2:
                System.out.println("case 2");
                break;
            default:
                System.out.println("default");
            case 3:
                System.out.println("case 3");
        }
        System.out.println("2============case 可以找到值 也有break ==end=============");

        System.out.println("3.============找不到case  有break ==start=================");
        System.out.println("3.1==========default 在 break 前====================");
        switch(x){
            default:
                System.out.println("default");
            case 4:
                System.out.println("case 4");
                break;
            case 3:
                System.out.println("case 3");;
        }

        System.out.println("3.2==========default 在break之后====================");
        switch(x){

            case 4:
                System.out.println("case 4");
                break;
            case 3:
                System.out.println("case 3");
            default:
                System.out.println("default");

        }
        System.out.println("3.3==========default 在break中====================");
        switch(x){
            default:
                System.out.println("default");
                break;
            case 4:
                System.out.println("case 4");
            case 3:
                System.out.println("case 3");
        }
        System.out.println("3============找不到case  有break ==end=============");

    }
}
