package org.tupurpcheung.learn.jdk.concurrency.chapter7;

/**
 * @author @tupurp
 * @date 2019/3/4 16:38
 *
 * 死锁
 *
 * jps
 * jstack pid
 */
public class DeadLockTest {

    public static void main(String [] args){
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);

        new Thread(){

            @Override
            public void run(){
                while (true){
                    deadLock.method();
                }
            }
        }.start();


        new Thread(){

            @Override
            public void run(){
                while (true){
                    otherService.method2();
                }
            }
        }.start();

    }
}
