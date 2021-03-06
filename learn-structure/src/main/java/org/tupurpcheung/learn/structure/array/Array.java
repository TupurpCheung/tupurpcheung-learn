package org.tupurpcheung.learn.structure.array;

/**
 * @author @tupurp
 * @projectName structure
 * @title Array
 * @package array
 * @description 动态数组
 * @date 2018/11/13 10:52
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E [] arr){
        data = (E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        size = arr.length;
    }


    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public Boolean isEmpty() {
        return size == 0;
    }


    public void addLast(E e) {

        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(2*data.length);
        }


        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i =0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }

        return data[index];
    }


    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }

        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }

        E ret = data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        return ret;

    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public void swap(int i,int j){
        if(i< 0|| i>= size || j< 0 || j>= size){
            throw new IllegalArgumentException("Index is illegal");
        }
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, capacity = %d \n", size, data.length));

        res.append('[');

        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i == size - 1) {

            } else {
                res.append(',');
            }

        }
        res.append(']');
        return res.toString();
    }


    public static void main(String[] args) {
        Array arr = new Array(20);
        System.out.println(arr);
    }
}
