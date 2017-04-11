package com.worldly.interfaces;

/**
 * a接口
 * 接口特性：
 *      1.接口用public abstract来修饰 可以省略，默认为public
 *      2.接口里的方法都是抽象的
 *      3.接口可以多extends
 *      4.接口中定义的属性都是常量
 *      5.抽象类实现接口可以不实现方法，可以到具体实现类里面实现方法
 *      6.
 *
 * @author Worldly
 * @create 2017-04-11 9:35
 **/
public interface A {

    //接口的方法默认为public abstract ,不能用其他修饰符修饰。
    void sayHello();
}
