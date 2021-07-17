package com.tupurpcheung.structure.stack;


import com.tupurp.learn.structure.array.Array;

/**
 * @author @tupurp
 * @projectName structure
 * @title ArrayStack
 * @package stack
 * @description 动态数组实现的栈
 * @date 2018/11/29 14:48
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<>();
    }


    @Override
    public void push(E e) {

        array.addLast(e);

    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.capacity();
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();

        res.append("Stack:");
        res.append("[ ");

        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }

        res.append(" ] top");


        return res.toString();
    }
}
