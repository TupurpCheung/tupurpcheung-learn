package com.tupurpcheung.structure.set;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title Set
 * @package set
 * @description 集合 不可添加重复元素
 * @date 2018/12/10 10:19
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();


}
