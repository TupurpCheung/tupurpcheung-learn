package com.tupurpcheung.spring.aop.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @description: 默认的后置处理器通知实现
 * @author: tupurp
 * @create: 2021-07-18 02:33
 */
public class DefaultMethodBeforeAdvice implements MethodBeforeAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMethodBeforeAdvice.class);

    @Override
    public void before(Method var1, Object[] var2, @Nullable Object var3) throws Throwable {
        LOGGER.info("java实现的前置切面处理器");
        var1.invoke(var3, var2);
    }


}