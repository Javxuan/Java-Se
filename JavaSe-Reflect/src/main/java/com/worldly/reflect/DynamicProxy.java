package com.worldly.reflect;

import java.lang.reflect.*;

/**
 * 利用反射来实现动态代理
 *  Java利用反射来实现动态代理：
 *   1.代理类要implements InvocationHandler的接口并重写invoke方法
 *   2.创建动态代理类  通过Class clazz = Proxy.getProxyClass(ClassLoader, interface[]);
 *   3.在通过反射获得 动态代里类的构造函数
 *   4.创建动态代理类的实例
 *   5.通过动态代理实例来调用代理方法，从而实现动态代理
 *
 * 动态代理的关键：
 *   就是Proxy.getProxyClass(ClassLoader,Interface[]);来获取动态代理类的Class对象，
 *   然后根据Class对象来完成动态代理对象的实例化
 *
 * @create 2017-04-17 22:04
 **/
public class DynamicProxy {

    public static void consumer(ProxyInterface proxyInterface){
        proxyInterface.say();
    }

    public static void main(String []args){
        /**
         * 实例化 被代理对象，
         * 通过构造方法传入到 代理类中
         * 因为代理列implements InvocationHandler接口就具有动态代理的功能。
         */
        Subject realSubject = new RealObject1();
        InvocationHandler invocationHandler = new ProxyObject1(realSubject);

        /**
         * 通过Proxy这个代理的Class对象 通过反射来创建代理对象
         * 1.通过类加载器来定义代理类 invocationHandler.getClass().getClassLoader() realSubject.getClass.getClassLoader()的效果是一样的
         * 2.被代理类实现的接口列表
         * 3.调用处理器
         */
        Subject  subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),invocationHandler);
        /**
         * 1.代理实例调用某个方法的时候
         * 2.会调用 动态代理对象里的 invoke方法
         *
         */
        subject.say();

        //=====================================动态创建代理对象的原始方式===================
        /**
         * 1.通过implements InvocationHandle 接口来创建自己的调用处理器
         * 2.并实现其invoke()方法 调用从代理类到被代理类的分派转发
         * 3.其内部通常包含执行被代理类实例的引用，用于真正执行分派转发过来的方法调用。
         */
        InvocationHandler in  = new ProxyObject1(realSubject);

        /**
         * 4.通过为Proxy类指定 ClassLoader对象和一组interface来创建动态代理类
         *  这里面的interface是被代理类
         */
        Class clazz= Proxy.getProxyClass(in.getClass().getClassLoader(),realSubject.getClass());

        /**
         * 5.通过反射机制获得动态代理类的构造函数，其为一的参数类型为调用处理接口类型
         */
        Constructor<?>  constructor=null;
        try {
            constructor = clazz.getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * 6.通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数传入
         */
        try {
            Subject subject2 = (Subject) constructor.newInstance(invocationHandler);
            subject2.say();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
}

/**
 * 抽象接口
 */
interface Subject{
    void say();
}

/**
 * 被代理对象
 */
class RealObject1 implements Subject{
    public void say(){
        System.out.println("真实被代理对象 的  say 方法被调用了");
    }
    public void doSomething(){
        System.out.println("其他未被调用的方法 ");
    }
}

/**
 * 代理对象
 */
class ProxyObject1 implements InvocationHandler{
    private Object subObject;
    public ProxyObject1(Object subObject){
        this.subObject = subObject;
    }

    public Object invoke(Object obj, Method method, Object [] args){
        System.out.println("代理对象工作了");
        System.out.println("代理实例调用 真实对象的方法 Method"+method);
        try {

            method.invoke(subObject,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
