package org.tupurpcheung.learn.jdk.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/4 15:36
 */
public class BankVersion3 {

    public static void main(String[] args) {
        final SynchronizedRunnable ticketWindow = new SynchronizedRunnable();

        Thread t1 = new Thread(ticketWindow, "1号窗口");
        Thread t2 = new Thread(ticketWindow, "2号窗口");
        Thread t3 = new Thread(ticketWindow, "3号窗口");

        t1.start();
        t2.start();
        t3.start();

    }
}
