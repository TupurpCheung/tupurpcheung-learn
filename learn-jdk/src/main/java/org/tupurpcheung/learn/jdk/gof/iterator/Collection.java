package org.tupurpcheung.learn.jdk.gof.iterator;

public interface Collection<E> extends Iterable<E> {

    void add(E e);

    int size();

}
