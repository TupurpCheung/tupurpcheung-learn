package com.tupurpcheung.java.gof.observer;

/**
 * @description: 婴儿醒来事件
 * @author: tupurp
 * @create: 2020-06-17 01:12
 */
public class WakeUpEvent implements Event{

    private Object source;

    public WakeUpEvent(Object obj){
        this.source = obj;
    }

    @Override
    public Object getSource() {
        return source;
    }
}