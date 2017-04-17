package com.worldly.reflect;

/**
 * 代码编译后的字节码文件
 *
 *   1.类经过编译后都生成了.class文件 每个.class文件都有一个Class对象
 *   2.类加载器会把.class文件加载到jvm 内存
 *   3.jvm只会生成一个字节码，但是jvm可以用这份字节码来创建多个对象。
 *
 * @author Worldly
 * @create 2017-04-17 15:53
 **/
public class ClassFile {
    public static void main(String []args){
        String s = "Hello";
        /**
         * 通过对象.getClass()来获取当前对象的Class对象
         */
        Class cls1 = s.getClass();

        /**
         * 通过类.class来获取当前类的Class对象
         */
        Class cls2 = String.class;


        Class cls3 =null;
        try {
            /**
             * 通过Class.forName("类的全路径")来获取该类的Class对象
             */
           cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 通过两个结果输出都为 true,true表明。
         *  jvm只会生成一个字节码，但是可以用这份字节码来创建多个对象。
         */
        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

    }

}
