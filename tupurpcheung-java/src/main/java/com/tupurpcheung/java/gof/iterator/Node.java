package com.tupurpcheung.java.gof.iterator;

public class Node<E> {
    E e;
    Node<E> next;

    public Node(E e, Node<E> next) {
        this.e = e;
        this.next = next;
    }
}
