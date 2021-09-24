package org.tupurpcheung.learn.jdk.concurrency.chapter2;

/**
 * @author @tupurp
 * @date 2019/3/1 9:48
 */
public class Bank {

    public static  void main(String [] args){
        TicketWindow ticketWindow = new TicketWindow("一号柜台");

        TicketWindow ticketWindow2 = new TicketWindow("二号柜台");

        TicketWindow ticketWindow3 = new TicketWindow("三号柜台");
        ticketWindow.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }
}
