package com.worldly.collection.set;

/**
 * 实现自然顺序比较
 * 自定义的对象要 实现 comparable<Object>接口  comparator接口
 * @author Worldly
 * @create 2017-04-12 21:29
 **/
public class Cat implements Comparable<Cat>{

    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //比较方法
    public int compareTo(Cat o) {
        if(o==null){
            throw new ExceptionInInitializerError("比较对象不能为空");
        }

        if(this.age>o.age){
            return 1;
        }else if(this.age==o.age){
            return 0;
        }
        return -1;
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
