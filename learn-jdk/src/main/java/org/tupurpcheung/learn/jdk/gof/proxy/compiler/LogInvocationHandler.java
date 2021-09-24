package org.tupurpcheung.learn.jdk.gof.proxy.compiler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {

    Logger logger = LoggerFactory.getLogger(LogInvocationHandler.class);

    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method)throws Exception {
        logger.info("== Compiler 动态代理的日志记录开始==");
        String methodName = method.getName();
        Class<?> clazz = method.getDeclaringClass();

        logger.info("类 {} 的 {} 方法 开始执行",clazz.getName(),methodName);

        Object result = method.invoke(this.target,new Object[]{});


        logger.info("类 {} 的 {} 方法 结束执行",clazz.getName(),methodName);

        logger.info("== Compiler动态代理的日志记录结束==");
        return result;
    }
}
