package com.worldly.operation;

/**
 * 字符串相加然后判断是否相等
 *  对于字符串常量相加
 *      1.编译器会有自动优化的操作：在编译时间就将常量相加 a = "taobao" 根据
 *      2.而b
 * @author Worldly
 * @create 2017-04-11 16:43
 **/
public class StringAdd {
    private static final String MESSAGE="taobao";
    public static void main(String [] args) {
        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);   //a与 message都是指向 字符串常量taobao 所以他们的引用地址值相等。
        System.out.println((b+c)==MESSAGE); //因为b 和c 在运行前都是不确定的，编译器不会做优化，而String的相加是通过StringBuffer
        //相加的 append后 转换为String存在 堆内存中，而 message 却存在字符串常量池中 与堆内存中是不想等的。
    }

}
