package com.tupurpcheung.java.concurrency.chapter2;

/**
 * @author @tupurp
 * @date 2019/3/1 14:59
 */
public class BankVersion2 {

    public static  void main(String[] args){
        final  TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread thread1 = new Thread(ticketWindowRunnable,"一号窗口");
        Thread thread2 = new Thread(ticketWindowRunnable,"二号窗口");
        Thread thread3 = new Thread(ticketWindowRunnable,"三号窗口");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
