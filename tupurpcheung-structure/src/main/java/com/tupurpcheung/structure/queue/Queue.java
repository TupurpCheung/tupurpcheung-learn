package com.tupurpcheung.structure.queue;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title Queue
 * @package queue
 * @description 队列  先进先出
 * @date 2018/12/6 16:00

 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
