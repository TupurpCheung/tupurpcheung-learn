package com.tupurpcheung.java.gof.proxy.cglib;


import com.tupurp.learn.gof.proxy.jdk.LogInvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/*
*
* 基于cglib实现动态代理
* */
public class LogMethodInterceptor implements MethodInterceptor {

    Logger logger = LoggerFactory.getLogger(LogMethodInterceptor.class);
    /*
    * 生成方法拦截器
    * @param target 要进行增强的对象（被代理对象）
    * @param method 拦截的方法
    * @param args 参数列表
    * @param methodProxy 方法的代理
    *
    * @return
    * @throws Throwable
    *
    * */
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("==cglib动态代理的前处理==");
        logger.info("类 {} 的 {} 方法 开始执行",target.getClass().getName(),method.getName());
        Object obj = methodProxy.invokeSuper(target,args);
        logger.info("类 {} 的 {} 方法 结束执行",target.getClass().getName(),method.getName());
        System.out.println("==cglib动态代理的后处理==");
        return obj;
    }
}
