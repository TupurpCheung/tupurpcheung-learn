package org.tupurpcheung.learn.jdk.concurrency.chapter10;

import java.util.Arrays;

/**
 * @author @tupurp
 * @date 2019/3/6 9:54
 */
public class ThreadGroupCreate {


    public static void main(String [] args){


        /**
         *
         *                tg1
         *             /     \
         *          t1        tg2
         *                   /
         *                 t3
         *
         *
         *
         *
         *
         *
         *
         * */
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1,"t1"){

            @Override
            public void run(){

                try {
                    System.out.println("t1--:" +getThreadGroup().getName());
                    System.out.println("t1--:" + getThreadGroup().getParent());
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };

        t1.start();
        System.out.println("main-- :" +t1.getThreadGroup().getName());

        ThreadGroup tg2 = new ThreadGroup(tg1,"TG2");
        System.out.println("tg2-- :" +tg2.getName());
        System.out.println("tg2-- :" +tg2.getParent());

        Thread t3 = new Thread(tg2,"t3"){

          @Override
            public void run(){
              System.out.println(tg1.getName());
              Thread[] threads = new Thread[tg1.activeCount()];

              ThreadGroup[] threadGroups = new ThreadGroup[tg1.activeGroupCount()];
              tg1.enumerate(threads);
              tg1.enumerate(threadGroups);
              Arrays.asList(threads).forEach(System.out::println);
              Arrays.asList(threadGroups).forEach(System.out::println);



          }


        };


        t3.start();


        Thread[] threadsRecurse = new Thread[tg1.activeCount()];
        System.out.println("=====================================================");
        tg1.enumerate(threadsRecurse,false);
        Arrays.asList(threadsRecurse).forEach(System.out::println);

        System.out.println("***************************************************");
        tg1.enumerate(threadsRecurse,true);
        Arrays.asList(threadsRecurse).forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        threadsRecurse = new Thread[10];
        Thread.currentThread().getThreadGroup().enumerate(threadsRecurse,false);
        Arrays.asList(threadsRecurse).forEach(System.out::println);

        System.out.println("#######################################################");
        threadsRecurse = new Thread[10];
        Thread.currentThread().getThreadGroup().enumerate(threadsRecurse,true);
        Arrays.asList(threadsRecurse).forEach(System.out::println);





//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());

    }
}
