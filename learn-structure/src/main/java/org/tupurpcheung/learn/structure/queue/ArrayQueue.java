package org.tupurpcheung.learn.structure.queue;


import org.tupurpcheung.learn.structure.array.Array;

/**
 * All rights Reserved, Designed By www.yingfeng365.com
 *
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title ArrayQueue
 * @package queue
 * @description ${TODO}
 * @date 2018/12/6 16:03
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);

    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.capacity();
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();

        res.append("Queue:");
        res.append("front [ ");

        for (int i = 0; i < array.size(); i++) {
            res.append(array.get(i));
            if (i != array.size() - 1) {
                res.append(", ");
            }
        }

        res.append(" ] tail");
        return res.toString();
    }


    public static  void main(String [] args){
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i <10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }

        }
    }
}
