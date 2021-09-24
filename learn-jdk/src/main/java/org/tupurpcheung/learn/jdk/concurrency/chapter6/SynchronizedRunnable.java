package org.tupurpcheung.learn.jdk.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/4 15:37
 *
 * 同步代码块
 */
public class SynchronizedRunnable implements Runnable {

    // read only
    private final int MAX_NUM = 100;


    private int index = 1;


    //锁是this
//    @Override
//    public void run() {
//
//        while (true) {
//            if (index <= MAX_NUM) {
//
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(Thread.currentThread().getName() + "的号码是：" + (index++));
//            } else {
//                break;
//            }
//
//        }
//
//    }


    @Override
    public void run() {
        while (true) {
            if(ticket()){break;}
        }
    }

    //锁是this
    private synchronized  boolean ticket(){
        if (index <= MAX_NUM) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //index = index + 1
            //1.get Field index
            //2. index = index + 1
            //3.put Field index
            System.out.println(Thread.currentThread().getName() + "的号码是：" + (index++));

            return false;
        } else {
            return true;
        }
    }
}
