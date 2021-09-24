package org.tupurpcheung.learn.spring.aop.runner;

import org.tupurpcheung.learn.spring.aop.advice.DefaultMethodAfterAdvice;
import org.tupurpcheung.learn.spring.aop.advice.DefaultMethodBeforeAdvice;
import org.tupurpcheung.learn.spring.aop.advised.AdvisedInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(MainRunner.class);
    @Resource
    AdvisedInstance point;

    @Override
    public void run(String... args) throws Exception {
        if (point instanceof Advised) {
            LOGGER.info("类实现了Advised接口");
            Advised point = (Advised) this.point;
            //前置增强
            point.addAdvice(new DefaultMethodBeforeAdvice());
            //后置增强
            point.addAdvice(new DefaultMethodAfterAdvice());
        }
        point.joinPoint();
    }

}