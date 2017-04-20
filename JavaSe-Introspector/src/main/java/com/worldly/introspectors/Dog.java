package com.worldly.introspectors;

/**
 * 通用的javaBean
 *   javaBean 是一个组件，广泛的来说相当于一个类。
 *   JavaBean 必须遵守一定的规则属性xxx 那getXxx 和setXxx， 以便java的内省机制来通过get set方法来探测到该类有哪些属性
 *   通常会将getXxx里面的 Xxx的第一个字母转小写。
 * @author Worldly
 * @create 2017-04-20 9:17
 **/
public class Dog {

    private String name;
    private int age;


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
