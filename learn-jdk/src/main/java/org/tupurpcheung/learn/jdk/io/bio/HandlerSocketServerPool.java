package org.tupurpcheung.learn.jdk.io.bio;

import java.util.concurrent.*;

public class HandlerSocketServerPool {
    private ExecutorService executorService;
    private static final int MAX_SIZE = 100;

    public HandlerSocketServerPool(int coreSize, int queueSize) {
        executorService = new ThreadPoolExecutor(coreSize, MAX_SIZE,
                20L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }


    public void execute(Runnable target){
        executorService.execute(target);
    }
}
