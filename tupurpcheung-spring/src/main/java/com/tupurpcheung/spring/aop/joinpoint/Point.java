package com.tupurpcheung.spring.aop.joinpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: 要被切面的类
 * @author: tupurp
 * @create: 2021-07-18 00:21
 */
@Component
public class Point {
    private static final Logger LOGGER = LoggerFactory.getLogger(Point.class);

    /**
     * 在aop中，切面实际是作用在方法上的，这些方法被称为 连接点 (joinPoint)
     * <p>
     * 通知（advice） 和 切入点（pointcut） 组成了 切面（AspectJ）
     * 其中通知决定做什么
     * 切入点决定在哪些连接点做通知
     *
     * </p>
     */
    public void joinPoint() {
        LOGGER.info("切入点方法被执行！");
    }
}