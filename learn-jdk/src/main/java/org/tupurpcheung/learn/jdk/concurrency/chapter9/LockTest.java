package org.tupurpcheung.learn.jdk.concurrency.chapter9;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author @tupurp
 * @date 2019/3/5 9:55
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {

        final BooleanLock booleanLock = new BooleanLock();

        Stream.of("T1", "T2", "T3", "T4").forEach(name -> {

            new Thread(() -> {

                try {
                    booleanLock.lock(1000L);
                    Optional.of(Thread.currentThread().getName() + " have the lock monitor.")
                            .ifPresent(System.out::println);
                    work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Lock.TimeOutException e) {
                    e.printStackTrace();

                } finally {
                    booleanLock.unLock();
                }


            }, name).start();

        });

        Thread.sleep(100);
        booleanLock.unLock();
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working...").ifPresent(System.out::println);

        Thread.sleep(10_000);
    }
}
