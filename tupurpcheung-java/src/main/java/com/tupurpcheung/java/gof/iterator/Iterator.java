package com.tupurpcheung.java.gof.iterator;

/*
* 迭代器
* @author tupurp
* @Date 2020-04-22
* */
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
