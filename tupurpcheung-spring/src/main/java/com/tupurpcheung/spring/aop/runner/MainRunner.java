package com.tupurpcheung.spring.aop.runner;

import com.tupurpcheung.spring.aop.advice.DefaultMethodBeforeAdvice;
import com.tupurpcheung.spring.aop.advised.AdvisedInstance;
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
            point.addAdvice(new DefaultMethodBeforeAdvice());
        }
        point.joinPoint();
    }

}