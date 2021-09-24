package org.tupurpcheung.learn.structure.stack;

/**
 * @author @tupurp
 * @projectName structure
 * @title Stack
 * @package stack
 * @description 栈 后进先出
 * @date 2018/11/29 14:45
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
