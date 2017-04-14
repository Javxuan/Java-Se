package com.worldly.collection.set;

/**
 * 狗对象
 *  自定义比较的规则 如果两个对象的名字和年龄也相同的话，就认定为相同的。
 * @author Worldly
 * @create 2017-04-12 19:33
 **/
public class Dog {
    private String name;
    private int age;

    /**
     * 重写Object 的hashCode 方法
     * 计算name的hashCode + age 作为hashCode 的值
     * @return
     */
    @Override
    public int hashCode(){
        System.out.println("计算hashCode");
        return (name==null)?0:name.hashCode()+age*27;
    }

    /**
     * 重写Object的equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(obj instanceof Dog){
            Dog dog  = (Dog) obj;
            if(this.name.equals(dog.name)&& this.getAge()==dog.getAge())
                return true;
            else
                return false;

        }else{
            return false;
        }
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
