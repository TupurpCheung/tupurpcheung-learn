package org.tupurpcheung.learn.jdk.concurrency.chapter8;

import java.util.stream.Stream;

/**
 * @author @tupurp
 * @date 2019/3/4 17:33
 * <p>
 * The difference of sleep and wait
 * 1. sleep is the method of Thread,but the wait is the method of Object.
 * 2: sleep will not release the object monitor(Lock),but the wait wll be release the monitor and add to the Object monitor waiting queue.
 * 3: use sleep not depend on the monitor,but wait need.
 * 4: The sleep method not need be wakeup,but wait need (expect wait(long time))
 */
public class DifferenceOfwaitAndSleep {


    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        Stream.of("t1","t2").forEach( n ->{

            new Thread(n){
              @Override
              public  void run(){

                  method();
              }

            }.start();

        });


        Stream.of("t1","t2").forEach( n ->{

            new Thread(n){
                @Override
                public  void run(){

                    method2();
                }

            }.start();

        });
            method2();

    }


    public static void method() {

        //2：sleep不会释放锁
        synchronized (LOCK){
            try {
                System.out.println("The Thread " + Thread.currentThread().getName() + " enter");
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method2() {

        //3： wait 如果 不使用 synchronized(LOCK){}同步，会报  Exception in thread "main" java.lang.IllegalMonitorStateException 异常
        //2：wait会释放锁
        synchronized (LOCK){
            try {
                System.out.println("The Thread " + Thread.currentThread().getName() + " enter");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
