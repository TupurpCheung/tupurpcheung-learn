package org.tupurpcheung.learn.jdk.concurrency.chapter4;

/**
 * @author @tupurp
 * @date 2019/3/4 11:38
 * <p>
 * interrupted()
 * <p>
 * 需要捕获到中断信号或者处理中断异常
 */
public class ThreadInterruptedAPI {

    private static Class MONITOR = ThreadInterruptedAPI.class;


    public static void main(String[] args) throws InterruptedException {


//        //方式1 sleep
//        Thread t = new Thread() {
//
//            @Override
//            public void run() {
//                while (true) {
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        System.out.println("收到打断信号。");
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(">>> " + this.isInterrupted());
//                }
//            }
//
//
//        };
//
//        //方式2 wait
//        Thread t2 = new Thread() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    synchronized (MONITOR){
//                        try {
//                            MONITOR.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            System.out.println(Thread.interrupted());
//                        }
//
//                    }
//                    System.out.println(">>> " + this.isInterrupted());
//                }
//            }
//
//
//        };




//        t.start();
//        Thread.sleep(100);
//        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());
//

//        t2.start();
//        Thread.sleep(10);
//        System.out.println(t2.isInterrupted());
//        t2.interrupt();
//        System.out.println(t2.isInterrupted());




        /************************************************************************************************************/
        //方式3  join也可以被打断
        Thread t3 = new Thread(){

            @Override
            public void run() {
                while (true) {

                }
            }
        };

        t3.start();
        Thread main = Thread.currentThread();

        Thread t4 = new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             //  t3.interrupt();
               main.interrupt();
                System.out.println("interrupt happen");
            }
        };


        t4.start();

        try{

            // join的是main线程
            t3.join();

        }catch(InterruptedException e){
            e.printStackTrace();

        }








    }

}
