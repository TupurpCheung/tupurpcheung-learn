package org.tupurpcheung.learn.jdk.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/4 16:03
 * <p>
 * 静态同步方法的锁是 class 锁
 */
public class SynchronizedStaticTest {

    public static void main(String[] args) {

        new Thread("T1") {

            @Override
            public void run() {
                SynchronizedStatic.method();
            }
        }.start();


        new Thread("T2") {

            @Override
            public void run() {
                SynchronizedStatic.method2();
            }
        }.start();

        new Thread("T3") {

            @Override
            public void run() {
                SynchronizedStatic.method3();
            }
        }.start();

    }
}
