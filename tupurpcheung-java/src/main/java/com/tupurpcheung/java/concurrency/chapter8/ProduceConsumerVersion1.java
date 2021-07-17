package com.tupurpcheung.java.concurrency.chapter8;

/**
 * @author @tupurp
 * @date 2019/3/4 16:47
 *
 *   生产者消费者--未进行线程间通信
 */
public class ProduceConsumerVersion1 {


    private int i = 1;

    private final Object LOCK = new Object();

    private void produce(){

        synchronized (LOCK){
            System.out.println("PRODUCE --> " + (i++) );
        }
    }

    private void consume(){

        synchronized (LOCK){
            System.out.println("CONSUMER --> " + i );
        }

    }



    public static void main(String [] args){

        ProduceConsumerVersion1 produceConsumerVersion1 = new ProduceConsumerVersion1();

        new Thread("Produce"){

            @Override
            public void run(){

                while (true) {
                    produceConsumerVersion1.produce();
                }
            }


        }.start();

        new Thread("Consume"){

            @Override
            public void run(){

                while (true) {
                    produceConsumerVersion1.consume();
                }
            }


        }.start();
    }
}
