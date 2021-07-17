package com.tupurpcheung.java.concurrency.chapter2;

/**
 * @author @tupurp
 * @date 2019/3/1 9:46
 */
public class TicketWindow extends Thread {

    private final String name;

    private static final int MAX_NUM = 50;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX_NUM) {
            System.out.println(name + "当前的号码是：" + (index++));
        }

    }


}
