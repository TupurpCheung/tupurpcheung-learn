package org.tupurpcheung.learn.jdk.gof.observer;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-17 01:20
 */
public class DogObserver implements Observer{
    @Override
    public void actionPerform(Event e) {
        System.out.println("狗儿开始汪汪");
    }
}