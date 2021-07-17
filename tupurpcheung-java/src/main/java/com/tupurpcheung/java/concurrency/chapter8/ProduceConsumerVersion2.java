package com.tupurpcheung.java.concurrency.chapter8;

/**
 * @author @tupurp
 * @date 2019/3/4 16:54
 * <p>
 * 生产者消费者--进行线程间通信
 * 生产一个消费一个
 * 不能支持多个生产者和多个消费者
 * 会造成假死，多个线程都放弃了CPU执行权
 */
public class ProduceConsumerVersion2 {

    private int i = 1;

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    private void produce() {

        synchronized (LOCK) {

            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("PRODUCE --> " + i);
                LOCK.notify();
                isProduced = true;
            }


        }
    }

    private void consume() {

        synchronized (LOCK) {

            if (isProduced) {
                System.out.println("CONSUMER --> " + i);
                LOCK.notify();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }


    public static void main(String[] args) {

        ProduceConsumerVersion2 produceConsumerVersion2 = new ProduceConsumerVersion2();

        new Thread("Produce") {

            @Override
            public void run() {

                while (true) {
                    produceConsumerVersion2.produce();
                }
            }


        }.start();

        new Thread("Consume") {

            @Override
            public void run() {

                while (true) {
                    produceConsumerVersion2.consume();
                }
            }


        }.start();
    }

}