package com.tupurpcheung.java.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/4 15:18
 *
 * 可使用 jstack 查看堆栈信息
 *
 */
public class SynchronizedTest {

    private final static Object LOCK = new Object();

    public static  void main(String [] args){


        Runnable runnable = () ->{

            synchronized(LOCK){

                try {
                    Thread.sleep(200_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();

    }
}
