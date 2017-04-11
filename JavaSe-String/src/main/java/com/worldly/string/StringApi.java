package com.worldly.string;

import java.io.UnsupportedEncodingException;

import static java.lang.String.copyValueOf;

/**
 * 熟悉String api
 *
 * @author Worldly
 * @create 2017-04-10 17:00
 **/
public class StringApi {

    public static void main(String [] args){
        //定义一个字符串
        String str="one car come, one car go, two car pengpeng,one car die";

        //返回指定索引处的字符
        char c = str.charAt(2);
        System.out.println("返回指定索引的字符=== "+c);

        //比较两个字符串的字典序列
        String str2= "ab";
        String str3 ="sb";
        int result1 = str2.compareTo(str3);
        System.out.println("返回两个字符串字典序列的比较结果=== "+result1);

        String result2 = str.intern();
        System.out.println("返回一个字符串的标准表示形式=== "+result2);

        try {
            byte[] result3 = str.getBytes("utf-8");
            System.out.println("返回一个字符串使用指定编码格式来返回字节数组=== "+result3.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        char[] b3= new char[60];
        str.getChars(0,str.length(),b3,5);
        System.out.println("将一个字符串里从指定的索引到结束索引之间的字符 从目标数组里指定的index开始覆盖"+b3[5]);

        String subStr = str.substring(3);
        String subStr2 = str.substring(0,12);
        System.out.println("截取子字符串序列从指定的索引到结尾处的子串"+subStr+"截取字符串从指定开始到结束不包含"+subStr2);

        String  result4 = str.trim();
        System.out.println("去除当前字符串开始和结束的空格 ==="+result4+"--");

        int i =10;
        System.out.println("返回int参数字符串int形式 ==="+Integer.valueOf(i));

        char [] ch = new char[]{'a','b','c','d','e','f','g'};
        String result5 = String.copyValueOf(ch,1,5);
        System.out.println("将字符数组转换成 字符串形式输出 ==="+result5);
    }

    /**
     * 答应字符数组里每个字符
     * @param ch1
     */
    private void show(char [] ch1) {
        for(int i=0;i<ch1.length;i++){
            System.out.print(ch1[i]+" ");
        }
    }



}
