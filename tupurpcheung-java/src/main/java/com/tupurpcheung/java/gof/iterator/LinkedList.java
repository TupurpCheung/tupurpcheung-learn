package com.tupurpcheung.java.gof.iterator;

public class LinkedList<E> implements Collection<E> {


    private Node<E> root;
    private Node<E> tail;
    private int size;

    @Override
    public void add(E e) {
        if (null == root) {
            root = new Node<>(e, null);
            tail = root;
        } else {
            Node node = new Node(e, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(root);
    }

    private class LinkedListIterator<E> implements Iterator<E> {
        private Node<E> cur;

        public LinkedListIterator(Node<E> cur) {
            this.cur = cur;
        }

        @Override
        public boolean hasNext() {
            return null != cur;
        }

        @Override
        public E next() {
            E e = cur.e;
            Node next = cur.next;
            cur = next;
            return e;

        }
    }

}
