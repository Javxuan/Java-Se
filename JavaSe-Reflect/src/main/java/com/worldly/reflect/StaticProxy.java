package com.worldly.reflect;

/**
 * 静态代理
 *
 * @author Worldly
 * @create 2017-04-18 8:56
 **/
public class StaticProxy {
    public static void consumer(ProxyInterface proxyInterface){
        proxyInterface.say();
    }

    public static void main(String [] args){
        consumer(new ProxyObject());
    }
}

/**
 * 要代理的接口
 */
interface ProxyInterface{
    void say();
}

/**
 * 被代理者
 */
class RealObject implements  ProxyInterface{
    public void say(){
        System.out.println("小明相亲ing");
    }
}

class ProxyObject implements  ProxyInterface{
    public void say(){
        System.out.println("成全公司接活，替小明安排相亲");
        new RealObject().say();
        System.out.println("小明相亲结束");
    }
}

