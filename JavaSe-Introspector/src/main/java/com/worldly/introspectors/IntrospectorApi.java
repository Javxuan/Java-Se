package com.worldly.introspectors;

/**
 * 内省的基础api
 *
 * @author Worldly
 * @create 2017-04-20 9:16
 **/
public class IntrospectorApi {
    public static void main(String []args){
        /**
         * 通常来说实例 化一个对象 都是通过 new 来完成的
         * 但是通过new 来完成的话，会造成使用者IntrospectorApi 与被使用者 Dog造成耦合
         *  如： 如果我下次我要新类型的Dog的话，就要改IntrospectorApi里面的实例化的代码
         *  这样耦合度就很高。
         *  通常我们会通过 DogFactory来实例化这个对象，通过传一个标记让 工厂知道要生成什么样的Dog
         */
        Dog dog = DogFactory.getDog("home");
        System.out.println(dog.toString());
    }
}
