package org.tupurpcheung.learn.jdk.concurrency.chapter4;

import java.util.Optional;

/**
 * @author @tupurp
 * @date 2019/3/4 10:45
 *
 * 简单API：getName(),getId(),getPriority()
 */
public class ThreadSimpleAPI {

    public static  void main(String [] args){
        Thread t = new Thread(() ->{


            Optional.of("Hello").ifPresent(System.out::println);

            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"t1");

        //t1
        Optional.of(t.getName()).ifPresent(System.out::println);
        //11  threadSeqNumber++
        Optional.of(t.getId()).ifPresent(System.out::println);
        //默认优先级  5  优先级并不能保证执行顺序，所以意义不大
        Optional.of(t.getPriority()).ifPresent(System.out::println);


        t.start();

    }



}
