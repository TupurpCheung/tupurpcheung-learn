package org.tupurpcheung.learn.jdk.concurrency.chapter6;

/**
 * @author @tupurp
 * @date 2019/3/1 14:56
 * 同步代码块
 * 可使用  javap -c class文件  反汇编
 *
 */
public class TicketWindowRunnable implements Runnable {

    private  final int MAX_NUM = 100;
    private  int index = 1;

    private final Object MONITOR = new Object();

    @Override
    public void run() {

        while (true){
            //同步代码块解决数据共享的问题
            synchronized (MONITOR){
                if(index <= MAX_NUM){
                    System.out.println( Thread.currentThread().getName() + "的号码是：" + (index++));
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }


        }

    }
}
