package com.tupurpcheung.java.gof.iterator;

public class ArrayList<E> implements Collection<E>{


    private Object[] container = new Object[10];
    private int size = 0;

    @Override
    public void add(E e) {
        if(size == container.length){
            Object[] newContainer = new Object[size * 2];
            System.arraycopy(container,0,newContainer,0,size);
            container = newContainer;
        }
        container[size] = e;
        size++;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<E> implements Iterator<E>{

        private int curIndex = 0;
        @Override
        public boolean hasNext() {
            return size > curIndex;
        }

        @Override
        public E next() {
            return (E)container[curIndex++];
        }
    }
}
