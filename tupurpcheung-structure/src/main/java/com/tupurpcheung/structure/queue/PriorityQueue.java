package com.tupurpcheung.structure.queue;


import com.tupurp.learn.structure.heap.MaxHeap;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title PriorityQueue
 * @package queue
 * @description 底层实现为堆（底层实现为动态数组）的优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;
    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.getSize() == 0;
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public String toString(){
        return null;
    }
}
