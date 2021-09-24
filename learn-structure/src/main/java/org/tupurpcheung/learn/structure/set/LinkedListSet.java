package org.tupurpcheung.learn.structure.set;


import org.tupurpcheung.learn.structure.linkedList.LinkedList;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title LinkedListSet
 * @package set
 * @description 链表 实现得集合
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;


    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }

    }

    @Override
    public void remove(E e) {
          list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
            return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
