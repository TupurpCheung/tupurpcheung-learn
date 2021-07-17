package com.tupurpcheung.spring.aop.runner;

import com.tupurpcheung.spring.aop.joinpoint.Point;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: tupurp
 * @create: 2021-07-18 00:50
 */
@Component
public class MainRunner implements CommandLineRunner {

    @Resource
    Point point;

    @Override
    public void run(String... args) throws Exception {
        point.joinPoint();
    }

}