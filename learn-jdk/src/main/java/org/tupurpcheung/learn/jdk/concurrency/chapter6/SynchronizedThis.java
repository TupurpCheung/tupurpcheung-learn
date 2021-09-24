package org.tupurpcheung.learn.jdk.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/4 15:50
 * <p>
 * <p>
 * 同步方法块的锁是this对象
 *
 * 没有同时输出，表明使用的是同一把锁
 */
public class SynchronizedThis {


    public static void main(String[] args) {


        ThisLock thisLock = new ThisLock();

        new Thread("T1") {
            @Override
            public void run() {
                thisLock.method();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                thisLock.method2();
            }
        }.start();

        new Thread("T3") {
            @Override
            public void run() {
                thisLock.method3();
            }
        }.start();

        new Thread("T4") {
            @Override
            public void run() {
                thisLock.method4();
            }
        }.start();

    }

}

class ThisLock {


    private final static Object LOCK = new Object();

    //锁是this
    public synchronized void method() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //锁是this
    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void method3() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void method4() {

        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}