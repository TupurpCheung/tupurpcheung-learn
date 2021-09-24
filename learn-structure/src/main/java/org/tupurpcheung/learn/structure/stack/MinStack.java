package org.tupurpcheung.learn.structure.stack;

import java.util.LinkedList;

/**
 * @author @tupurp
 * @projectName structure
 * @title MinStack   leetcode 155 最小栈
 * @package stack
 * @description ${TODO}
 * @date 2018/12/6 11:22
 */
class MinStack {

    /**
     * initialize your data structure here.
     */

    class Elem {

        private int value;
        private int min;

        public Elem(int value, int min) {
            this.value = value;
            this.min = min;
        }

        private int getMin() {
            return min;
        }

    }

    private LinkedList<Elem> stack;


    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {

        if (stack.size() == 0) {
            Elem elem = new Elem(x, x);
            stack.add(elem);
        } else {
            Elem first = stack.getLast();
            int min = first.getMin();

            if (x <= min) {
                Elem elem = new Elem(x, x);
                stack.addLast(elem);
            } else {
                Elem elem = new Elem(x, min);
                stack.addLast(elem);
            }
        }

    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast().value;
    }

    public int getMin() {
        return stack.getLast().getMin();
    }


}