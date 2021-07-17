package com.tupurpcheung.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: 切面定义
 * @author: tupurp
 * @create: 2021-07-18 02:17
 */
@Aspect
@Component
public class PointAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PointAspect.class);

    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
    @Pointcut("execution(public * com.tupurpcheung.spring.aop..*.*(..))")
    public void pointCut(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        String typeName = joinPoint.getSignature().getDeclaringTypeName();
        String name = joinPoint.getSignature().getName();
        LOGGER.info("--类：{}的 {} 方法前置通知---",typeName,name);

    }


}