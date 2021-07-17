package com.tupurpcheung.java.concurrency.chapter2;

/**
 * @author @tupurp
 * @date 2019/3/1 14:56
 */
public class TicketWindowRunnable implements Runnable {

    private  final int MAX_NUM = 50;
    private  int index = 1;


    @Override
    public void run() {
        while (index <= MAX_NUM) {
            System.out.println( Thread.currentThread() + "的号码是：" + (index++));
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
