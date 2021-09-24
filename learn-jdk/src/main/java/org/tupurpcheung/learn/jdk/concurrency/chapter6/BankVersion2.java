package org.tupurpcheung.learn.jdk.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/4 15:00
 *
 * 线程数据安全
 * 线程数据同步的问题
 */
public class BankVersion2 {

    public  static  void main(String[] args){

        TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread window1 = new Thread(ticketWindowRunnable,"窗口1");
        Thread window2 = new Thread(ticketWindowRunnable,"窗口2");
        Thread window3 = new Thread(ticketWindowRunnable,"窗口3");


        window1.start();
        window2.start();
        window3.start();
    }

}
