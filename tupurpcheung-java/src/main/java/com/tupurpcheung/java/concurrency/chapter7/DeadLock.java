package com.tupurpcheung.java.concurrency.chapter7;

/**
 * @author @tupurp
 * @date 2019/3/4 16:29
 */
public class DeadLock {


    private OtherService otherService;

    private final Object LOCK = new Object();


    public DeadLock(OtherService otherService){
        this.otherService = otherService;
    }

    public void  method(){

            synchronized (LOCK){
                System.out.println(" -----------DEAD LOCK METHOD1-----------");
                otherService.method();
            }

    }

    public void  method2(){

        synchronized (LOCK){
            System.out.println(" -----------DEAD LOCK METHOD2-----------");
        }

    }

}
