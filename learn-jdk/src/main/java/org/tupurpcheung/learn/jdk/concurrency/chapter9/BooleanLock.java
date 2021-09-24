package org.tupurpcheung.learn.jdk.concurrency.chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * @author @tupurp
 * @date 2019/3/5 9:48
 */
public class BooleanLock implements Lock {

    /**
     * the initValue is true indicated the lock have be get.
     * the initValue is false indicated the lock is free （other thread can get this）.
     */
    private boolean initValue;


    private Collection<Thread> blockThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock() {
        this.initValue = false;
    }


    @Override
    public synchronized void lock() throws InterruptedException {

        while (initValue) {
            blockThreadCollection.add(Thread.currentThread());
            this.wait();
        }

        blockThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        currentThread = Thread.currentThread();

    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {

        if (mills <= 0) {
            lock();
        }

        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if (hasRemaining <= 0) {
                throw new TimeOutException("current Thread--" + Thread.currentThread().getName() + "-- get the lock Time out.");
            }
            blockThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = endTime  - System.currentTimeMillis() ;
        }


        blockThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        currentThread = Thread.currentThread();

    }

    @Override
    public synchronized void unLock() {
        /**只能由加锁的线程来解锁*/
        if (currentThread != Thread.currentThread()) {
            return;
        }

        this.initValue = false;
        Optional.of(Thread.currentThread().getName() + " release the lock monitor").ifPresent(System.out::println);
        this.notifyAll();
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockThreadCollection.size();
    }
}
