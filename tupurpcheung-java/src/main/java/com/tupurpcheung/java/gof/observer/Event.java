package com.tupurpcheung.java.gof.observer;

/**
 * 观察者模式
 *
 * 事件
 * */
public interface Event<T> {

    T getSource();
}
