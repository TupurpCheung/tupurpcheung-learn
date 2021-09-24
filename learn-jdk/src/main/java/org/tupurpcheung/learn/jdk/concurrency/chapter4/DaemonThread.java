package org.tupurpcheung.learn.jdk.concurrency.chapter4;

/**
 * @author @tupurp
 * @date 2019/3/4 10:17
 *
 * 守护线程
 * main线程与Thread-0线程处于同一个ThreadGroup中，只有两个线程全部结束，进程才结束
 *
 * 线程优先级
 *
 */
public class DaemonThread {


    public static void main(String [] args){
        //new
        Thread t = new Thread(){

            @Override
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName() + " running ....");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+ " done ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        //设置为守护线程，main线程在结束后，main线程创建的守护线程也结束
        t.setDaemon(true);
        //runnable   -> running | dead | blocked
        t.start();
        try {
            //JDK1.7之后
            Thread.sleep(5_000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
