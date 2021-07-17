package com.tupurpcheung.java.concurrency.chapter7;

/**
 * @author @tupurp
 * @date 2019/3/4 16:29
 */
public class OtherService {


    private final Object LOCK = new Object();

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    private DeadLock deadLock;

    public void  method(){

        synchronized (LOCK){
            System.out.println(" -----------OTHER SERVICE.-----------");
        }

    }

    public void  method2(){

        synchronized (LOCK){
            System.out.println(" -----------OTHER SERVICE METHOD2-----------");
            deadLock.method2();
        }

    }


}
