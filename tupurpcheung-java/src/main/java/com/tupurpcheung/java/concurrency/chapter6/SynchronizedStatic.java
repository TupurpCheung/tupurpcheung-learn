package com.tupurpcheung.java.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/4 16:01
 * <p>
 * 静态同步方法的锁是 class 锁
 */
public class SynchronizedStatic {


    static {
        synchronized (SynchronizedStatic.class) {
            System.out.println("static method " + Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized static void method() {
        System.out.println("method " + Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void method2() {
        System.out.println("method2 " + Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method3() {
        System.out.println("method3 " + Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
