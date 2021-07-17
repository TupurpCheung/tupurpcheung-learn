package com.tupurpcheung.structure.stack;


import com.tupurp.learn.structure.linkedList.LinkedList;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title LinkedListStack
 * @package stack
 * @description 链表实现的栈

 */
public class LinkedListStack<E> implements Stack<E> {


    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();

        res.append("LinkedListStack: top ");
        res.append(list);
        return res.toString();
    }

}
