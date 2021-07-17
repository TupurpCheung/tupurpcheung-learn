package com.tupurpcheung.java.gof.observer;

/**
 * @description:
 * @author: tupurp
 * @create: 2020-06-17 01:19
 */
public class MomObserver implements Observer{
    @Override
    public void actionPerform(Event e) {
        System.out.println("妈妈抱起宝宝");
    }
}