package org.tupurpcheung.learn.jdk.concurrency.chapter8;

import java.util.stream.Stream;

/**
 * @author @tupurp
 * @date 2019/3/4 17:01
 * * 生产者消费者--进行线程间通信
 * * 生产多个消费多个
 *
 *
 *
 *
 * The difference of sleep and wait
 * 1. sleep is the method of Thread,but the wait is the method of Object.
 * 2: sleep will not release the object monitor(Lock),but the wait wll be release the monitor and add to the Object monitor waiting queue.
 * 3: use sleep not depend on the monitor,but wait need.
 * 4: The sleep method not need be wakeup,but wait need (expect wait(long time))
 *
 */
public class ProduceConsumerVersion3 {

    private int i = 1;

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    private void produce() {

        synchronized (LOCK) {

            while (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("PRODUCE --> " + i);
            isProduced = true;
            LOCK.notifyAll();

        }
    }

    private void consume() {

        synchronized (LOCK) {

            while (!isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("CONSUMER --> " + i);
            isProduced = false;
            LOCK.notifyAll();


        }

    }


    public static void main(String[] args) {

        ProduceConsumerVersion3 produceConsumerVersion3 = new ProduceConsumerVersion3();

        Stream.of("P1", "P2").forEach(n -> new Thread(n) {

            @Override
            public void run() {

                while (true) {
                    produceConsumerVersion3.produce();
                }
            }


        }.start());


        Stream.of("C1", "C2").forEach(n -> new Thread(n) {

            @Override
            public void run() {

                while (true) {
                    produceConsumerVersion3.consume();
                }
            }
        }.start());

    }

}
