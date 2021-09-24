package org.tupurpcheung.learn.jdk.concurrency.chapter4;

/**
 * @author @tupurp
 * @date 2019/3/4 10:32
 *
 * 子线程被设置为守护线程（setDaemon），则当父线程退出时，子线程也跟着退出
 *
 *
 */
public class DaemonThread2 {

    public static  void main(String [] args){


        Thread t = new Thread(()->{

            Thread innerThread = new Thread(() ->{

                try {
                    while (true){
                        System.out.println("Do something for health check..");
                        Thread.sleep(1_000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //如果不设置为守护线程，则t线程退出后，innerThread线程不会退出
            innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        //t.setDaemon(true);
        t.start();

    }



}
