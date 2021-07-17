package com.tupurpcheung.spring.aop.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @description: 默认的后置处理器通知实现
 * @author: tupurp
 * @create: 2021-07-18 02:33
 */
public class DefaultMethodAfterAdvice implements AfterReturningAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMethodAfterAdvice.class);


    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        LOGGER.info("java实现的后置切面处理器");
    }
}