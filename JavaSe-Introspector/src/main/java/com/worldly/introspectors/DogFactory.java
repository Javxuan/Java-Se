package com.worldly.introspectors;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * dog的简单工厂
 *  通过配置文件 ---》反射 ------》内省  完成dog对象的实例化
 *
 * @author Worldly
 * @create 2017-04-20 9:25
 **/
public class DogFactory {

    private static Properties config = new Properties();

    /**
     * 在类加载的时候，第一个加载，先与构造函数，并且只加载一次
     * 通过静态块来加载配置文件
     */
    static{
        /**
         * 通过当前线程的 上下文类加载器 把配置文件加载成流 共Properties对象使用
         * Properties对象从流中加载配置文件。
         */
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dog.properties");
        try {
            config.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dog工厂类通常通过 接收一个标志符，然后根据这个标志符再去实例化相应的对象。
     * 如果 在这里也通过new 来完成相关的操作化也会造成 耦合
     * 所以我们又想把这个生成实例的类通过传一个类的全名 ，再通过 Class.forName("类全名")来得到Class对象
     * 在去实例化该类的对象
     * @param name
     * @return
     */
    public static Dog getDog(String name){
        try {
            //通过传入的标志符 来作为key 读取配置文件中该key的value, 从而通过反射 的Class对象。
            Class className = Class.forName(config.getProperty(name));
            // 通过Class对象进行 该类对象的实例化
            Dog dog = (Dog) className.newInstance();

            /**
             * 1.通过 dog.getName(), dog.setName(String name)方法来给对象属性赋值
             * 2.如果该类比较复杂，事先就不清楚有多少属性和方法的话，只有通过内省机制来获得。
             * 3. BeanInfo  beanInfo= Introspector.getBeanInfo()来取得bean信息
             * 4.在通过 beanInfo.getMethodDescriptors()来取得该bean 方法的信息描述器
             * 5.然后在通过Method对象的invoke方法来给对应的属性赋值
             */

            //Introspector通过对象的Class对象来获取该bean的信息
            BeanInfo beanInfo = Introspector.getBeanInfo(className);
            //通过beanInfo来取得相应的描述器
            PropertyDescriptor [] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor propertyDescriptor :propertyDescriptors){
                //通过属性描述器得到属性名
                if("name".equals(propertyDescriptor.getName())){
                    //通过配置文件加载dog的属性值
                    String nameValue = config.getProperty("dog.name");
                    //通过属性描述器的属性值写入的方法
                    Method method = propertyDescriptor.getWriteMethod();
                    //通过反射来得到相关属性的值
                    /**
                     * 表是 dog对象调用该Method对象代表的方法
                     * Method对象表示 dog里面一些方法的信息，就相当于Class对象 代表着某个class的信息
                     */
                    method.invoke(dog,nameValue);
                }else if("age".equals(propertyDescriptor.getName())){
                    int ageValue =Integer.parseInt(config.getProperty("dog.age"));
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(dog,ageValue);
                }
            }
            return dog;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
