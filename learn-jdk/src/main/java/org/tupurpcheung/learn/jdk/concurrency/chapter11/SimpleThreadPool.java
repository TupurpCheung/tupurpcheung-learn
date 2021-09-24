package org.tupurpcheung.learn.jdk.concurrency.chapter11;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author @tupurp
 * @date 2019/3/6 11:02
 * <p>
 * 简易版线程池
 * 基本概念：
 * 1-任务队列
 * 2-拒绝策略（抛出异常，直接丢弃，阻塞，临时队列）
 * 3-初始化值（init  min）
 * 4-真正运行的值（active）
 * 5-最大值（max）
 * min<= active <= max
 */
public class SimpleThreadPool {

    private final int size;

    private final static int DEFAULT_SIZE = 10;


    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("POOL_GROUP");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();


    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }


    private void init() {

        for (int i = 0; i < size; i++) {
            crateWorkTask();
        }

    }

    public void submit(Runnable runnable) {
        synchronized (TASK_QUEUE) {

            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }


    private void crateWorkTask() {
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }


    private enum TaskState {
        /**
         * 可用
         */
        FREE,
        /**
         * 运行
         */
        RUNNING,
        /**
         * 阻塞
         */
        BLOCKED,
        /**
         * 死亡
         */
        DEAD
    }


    private static class WorkerTask extends Thread {


        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        @Override
        public void run() {

            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }

                    runnable = TASK_QUEUE.removeFirst();
                }

                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }

            }

        }


        public void close() {
            this.taskState = TaskState.DEAD;
        }

    }


    public static void main(String[] args) {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();



        for (int i = 0; i < 40 ; i++) {
            simpleThreadPool.submit(()->{

                System.out.println("The runnable  be serviced by " +Thread.currentThread() + " start");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("The runnable  be serviced by " +Thread.currentThread() + " finished");
            });
            System.out.println("============");

        }

    }


}
