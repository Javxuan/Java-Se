package com.worldly.string;

/**
 * StringBuffer与StringBuilder的api
 *
 * @author Worldly
 * @create 2017-04-10 21:05
 **/
public class StringBufferBuilderApi {

    public static void  main(String [] args){
        //定义一个给定长度的StringBuffer；
        StringBuffer sb = new StringBuffer(18);

        //返回当前字符缓冲的当前容量
        int capacity = sb.capacity();
        System.out.println("返回当前字符缓冲区的容量大小 === "+capacity);

        char [] ch = {'1','2','9','0','1'};
        sb=sb.append(ch);
        System.out.println("将当前的字符数组，以字符串表现形式 追加到sb后面=== "+sb.toString()+ " sb的长度为="+ sb.length());

        Integer i = null;
        sb=sb.append(i);
        System.out.println("将当前的字符数组，如果i为null 则以字符串表现形式追加到sb后面=== "+sb.toString()+ " sb的长度为="+ sb.length());

        sb = sb.deleteCharAt(3);
        System.out.println("sb删除当前指定索引处的字符== "+sb.toString()+ " sb的长度为="+ sb.length());

        sb = sb.replace(4,8,"_123");
        System.out.println("用 指定的123 来替换 sb中当前指定索引区间段的处的字符== "+sb.toString()+ " sb的长度为="+ sb.length());

        sb.insert(7,false);
        System.out.println("sb在指定索引处插入了 boolean 的String 的值 == "+sb.toString()+ " sb的长度为="+ sb.length());

        sb.reverse();
        System.out.println("返回sb的反向输出 == "+sb.toString()+ " sb的长度为="+ sb.length());



    }


}
