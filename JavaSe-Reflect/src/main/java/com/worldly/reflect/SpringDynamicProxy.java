package com.worldly.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * spring中实现的动态代理的原则
 *
 * @author Worldly
 * @create 2017-04-18 15:33
 **/
public class SpringDynamicProxy {
    public static void main(String [] args){
        //实例化被代理的真实主题
        UserOper realUserOper = new UserOperImpl();
        InvocationHandler invocationHandler = new TransciationInvocation(realUserOper);
        //创建动态代理对象
        UserOper userOper =(UserOper) Proxy.newProxyInstance(realUserOper.getClass().getClassLoader(),realUserOper.getClass().getInterfaces(),invocationHandler);

        userOper.addUser();

    }
}

/**
 *代理主题
 */
interface UserOper{
    void  addUser();
}

class UserOperImpl implements  UserOper{
    public void addUser(){
        System.out.println("添加用户");
    }
}

/**
 * 代理对象
 */
class TransciationInvocation implements InvocationHandler {
    private Object target;
    public TransciationInvocation(Object target){
        super();
        this.target = target;
    }
    public Object invoke(Object prox1y, Method methods ,Object [] args){
        System.out.println("开启事务");
        try {
            methods.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("结束事务");
        return null;
    }
}
