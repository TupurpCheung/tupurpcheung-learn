package com.tupurpcheung.java.concurrency.chapter3;

/**
 * @author @tupurp
 * @date 2019/3/1 15:15
 *  Thread构造方法   线程名称的形参
 *                   线程的执行逻辑
 * <p>
 *     1:创建线程对象Thread,默认有一个线程名，以Thread-开头，从0开始计数
 *     2：如果在构造Thread函数时，没有传递Runnable或者没有复写Thread的run方法，该Thread将不会调用任何东西，否则会执行该方法
 *     的逻辑单元（逻辑代码）
 *
 *
 *
 */
public class CreateThread {

    public static void main(String[] args){
        Thread t = new Thread();
        Thread t2 = new Thread();
        t.start();
        t2.start();
        System.out.println(t.getName());
        System.out.println(t2.getName());


        Thread t3 = new Thread("MyName");
        Thread t4 = new Thread(() ->{
            System.out.println("Runnable .....");
        });

        t3.start();
        t4.start();
        System.out.println(t3.getName());
        System.out.println(t4.getName());

        Thread t5 = new Thread(() ->{
            System.out.println("Runnable ....." + Thread.currentThread().getName());
        },"RunnableThread");

        t5.start();
        System.out.println(t5.getName());

    }

}
