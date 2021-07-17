package com.tupurpcheung.java.concurrency.chapter9;

/**
 * @author @tupurp
 * @date 2019/3/5 10:09
 *
 *
 * 无法打断
 */
public class SynchronizedProblem {

    public static void main(String[] args) throws InterruptedException {

       new Thread(){
            @Override
            public void run(){

                System.out.println("....t1....");
                SynchronizedProblem.run();
            }
        }.start();

       Thread.sleep(1000);

       Thread t2 = new Thread(){
         @Override
         public void run(){
             System.out.println(".....t2.....");
             SynchronizedProblem.run();
         }
       };


       t2.start();

    }

    private synchronized static void run() {

        System.out.println(Thread.currentThread().getName());
        while (true) {

        }
    }
}
