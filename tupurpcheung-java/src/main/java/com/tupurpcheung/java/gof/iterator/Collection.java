package com.tupurpcheung.java.gof.iterator;

public interface Collection<E> extends java.lang.Iterable<E> {

    void add(E e);

    int size();

}
