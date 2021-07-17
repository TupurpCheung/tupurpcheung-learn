package com.tupurpcheung.java.gof.proxy.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
*
* jdk动态代理
* 动态代理类需要实现java.lang.reflect.InvocationHandler接口
* 目标对象（被代理对象）可以通过构造方法或方法注入
* */
public class LogInvocationHandler  implements InvocationHandler {

    Logger logger = LoggerFactory.getLogger(LogInvocationHandler.class);

    private Object target;

    /*空构造*/
    public LogInvocationHandler(){

    }

    /*
    * 构造方法注入,缺点是调用者还需要自己创建代理对象
    * */
    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 方法注入被代理对象，并返回代理对象
     * */
    public Object bind(Object target){
        this.target = target;
        //通过反射创建代理对象实例并返回
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    /*
    * 接口犯法
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==jdk动态代理的前处理==");
        String methodName = method.getName();
        Class<?> clazz = method.getDeclaringClass();

        logger.info("类 {} 的 {} 方法 开始执行",clazz.getName(),methodName);

        Object result = method.invoke(this.target,args);

        logger.info("类 {} 的 {} 方法 结束执行",clazz.getName(),methodName);

        System.out.println("==jdk动态代理的后处理==");
        return result;
    }
}
