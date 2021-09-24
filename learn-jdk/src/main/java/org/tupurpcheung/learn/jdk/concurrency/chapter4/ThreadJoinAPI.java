package org.tupurpcheung.learn.jdk.concurrency.chapter4;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author @tupurp
 * @date 2019/3/4 10:56
 *
 * join()的使用
 *
 *thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 *
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
 * t.join();      //调用join方法，等待线程t执行完毕
 * t.join(1000);  //等待 t 线程，等待时间是1000毫秒。
 *
 */
public class ThreadJoinAPI {

    public static void main(String [] args){

        Thread t = new Thread(() ->{
            IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getName()+ " --->" +i));
        });

        Thread t2 = new Thread(() ->{
            IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getName()+ " --->" +i));
        });
        t.start();
        t2.start();
        try {
            //join()必须全部放在start()之后
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Optional.of("All of tasks finish done").ifPresent(System.out::println);

        IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getName()+ " --->" +i));


        // 线程在等自己死，但自己不死，所以线程就不会结束
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
