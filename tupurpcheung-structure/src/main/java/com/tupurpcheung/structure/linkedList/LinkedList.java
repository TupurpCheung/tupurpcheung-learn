package com.tupurpcheung.structure.linkedList;

/**
 * @author @tupurp
 * @version V1.1
 * @projectName structure
 * @title LinkedList
 * @package linkedList
 * @description 链表
 * @date 2018/12/6 17:08
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);

        size++;
    }

    /**
     * 在链表的头部添加新的元素e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }


    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;

    }


    public boolean contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E reomve(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    public E removeFirst() {

        return reomve(0);
    }

    public E removeLast() {
        return reomve(size - 1);
    }

    public void removeElement(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {

            Node target = pre.next;

            if (target.e.equals(e)) {
                Node next = target.next;
                pre.next = next;
                target.next = null;
                return;
            }
        }
    }


    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }


}
