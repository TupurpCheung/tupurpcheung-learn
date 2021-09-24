package org.tupurpcheung.learn.jdk.concurrency.chapter9;

import java.util.Collection;

/**
 * @author @tupurp
 * @date 2019/3/5 9:46
 */
public interface Lock {

    class TimeOutException extends Exception{

        public TimeOutException(String message){
            super(message);
        }
    }


     void lock() throws InterruptedException;


    void lock(long mills)throws InterruptedException,TimeOutException;


    void unLock();


    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
