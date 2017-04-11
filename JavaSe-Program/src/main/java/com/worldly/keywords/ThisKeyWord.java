package com.worldly.keywords;

import com.worldly.extend.*;

/**
 * this 关键字的用法
 *  1.表示当前对象
 *  2.调用构造方法，但必须放在构造方法的第一行
 *  3.调用类中的属性
 * @author Worldly
 * @create 2017-04-11 11:30
 **/
public class ThisKeyWord extends Dog{

    private String name;

    public ThisKeyWord(String name){
      super(); //因为 不带参的构造函数调用了带参的构造函数，所以可以不传参也可以实现由参构造函数
      this.name =name;   //调用类中的属性和表示当前对象

    }

    public static void  main(String [] args){
        ThisKeyWord tkw = new ThisKeyWord("小狗");

    }
}
