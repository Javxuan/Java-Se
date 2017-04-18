package com.worldly.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * java反射机制的api
 *   1. java反射的理解
 a.程序的写好了再jvm里面运行，写好的代码先编译成.class文件的字节码 每个.class文件里都会产生一个Class对象
 b.类加载器来把 .class文件加载到 jvm 内存里
 c1.jvm 创建对象，jvm创建对象的时候会先看下该对象的类是否加载，即看该类的Class对象是否存在。
 （正常的逻辑，要创建对象，就要先知道类，然后再通过类来 新建对象，然后才能调用该类的方法和属性等）
 c2. 有的时候可能有某个类是不确定(如jdbc 时使用的数据库)，这只有使用的时候才会确定，所以字节码里一开始并没有，
 所以jvm通过正常的逻辑是创建不了的。可以用Java的反射来创建(Java反射，是通过Class对象 来确定类，从而再创建对象。)

 2. java 反射创建对象
 a.先取的某个类的Class对象 如：Class  cls = Class.forName("类的全路径");
 b.Object obj = cls.newInstance();
 *
 * @author Worldly
 * @create 2017-04-17 10:03
 **/
public class ReflectApi {

    public static void main(String [] args){
        try {
            Class<?> cls = Class.forName("com.worldly.reflect.Person");

            /**
             * 取得改类的全部的构造方法
             */
            Constructor<?>[]  constructors = cls.getConstructors();


            /**
             * 取得该类的所有方法
             * 方法为公共的
             */
            Method [] methods = cls.getMethods();

            /**
             * 取得改类声明的方法
             * 包括 私有，默认，保护，公共
             * 不包括父类extends的方法
             */
            Method[] methods2 = cls.getDeclaredMethods();

            /**
             * 取得该类的所有属性
             *  公共的字段
             */
            Field [] fields = cls.getFields();

            /**
             * 获取声明的属性
             */
            Field[] filds = cls.getDeclaredFields();


            /**
             * 通过反射来实例化对象、
             * 不带参的可以直接使用 cls.newInstance();
             * 取得指定参数类型的构造方法
             *
             */
            try {
                Constructor<?> cons = cls.getConstructor(String.class,int.class);
                Object obj = cons.newInstance("反射",0);
            } catch (Exception e) {
                e.printStackTrace();
            }


            /**
             * 利用反射调用类的普通方法
             * 如set get方法；
             */
            try {
                // 实例化对象，没有向Person转型
                Object obj = cls.newInstance();
                //类中的属性
                String attribute = "name";
                //setName()
                Method setMet = cls.getMethod("set"+initcap(attribute),String.class);
                //getName()
                Method getMet = cls.getMethod("get"+initcap(attribute));

                // 等价于：Person对象.setName("张三")
                /**
                 * invoke(Object obj,Object orgs) 表示调用obj里面的方法 ，参数为orgs
                 */
                setMet.invoke(obj,"张三");

                // 等价于：Person对象.getName()
                System.out.println(getMet.invoke(obj));

            } catch (Exception e) {
                e.printStackTrace();
            }

            /**
             * 调用私有的方法
             *   name表示方法名， parameterTypes表示 参数类型没有就为空
             */
            try {
                Object obj = cls.newInstance();
                Method  privateMethod = cls.getDeclaredMethod("hello",null);
                //忽略检查访问修饰符,设成可以访问的
                privateMethod.setAccessible(true);
                privateMethod.invoke(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取属性名的第一个字母
     * @param str
     * @return
     */
    public static String initcap(String str){
        return str.substring(0,1).toUpperCase().concat(str.substring(1));
    }
}

class Person{
    private String name;
    private int age;

    public Person (){
        //调用另外的构造方法
        this("a",0);
    }
    public Person (String name,int age){
        this.name = name;
        this.age=age;
    }

    public void say(){
        System.out.println("调用 公用的方法");
    }

    private void hello(){
        System.out.println("调用private 方法，要把修饰检验关闭，然后再调用");
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

}