package org.tupurpcheung.learn.jdk.concurrency.chapter3;

import java.util.Arrays;

/**
 * @author @tupurp
 * @date 2019/3/1 15:59
 *
 * Thread构造方法   线程的线程组（ThreadGroup）传参
 *
 * 3:如果构造线程Thread对象时，未传入ThreadGroup，则Thread会默认获取父线程的ThreadGroup作为该线程的ThreadGroup，此时
 * 子线程与父线程处于同一个ThreadGroup中
 *
 */
public class CreateThread2 {

    public static  void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

        System.out.println(t.getThreadGroup().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);


        Arrays.asList(threads).forEach(System.out::println);

        System.out.println("----------------------");
        for (Thread temp: threads
             ) {
            System.out.println(temp);
        }


    }
}
