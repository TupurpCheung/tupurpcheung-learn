package com.tupurpcheung.java.concurrency.chapter5;

/**
 * @author @tupurp
 * @date 2019/3/4 14:30
 * 针对ThreadCloseForce3的解决方案
 * 将 真正执行任务 的线程（runner）设置为 执行线程（executeThread）的守护线程
 * 当执行线程关闭，则runner线程（守护线程）也关闭
 */
public class ThreadService {

    private Thread executeThread;

    private boolean finished = false;


    public void execute(Runnable task) {


        executeThread = new Thread() {
            @Override
            public void run() {

                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
                //    e.printStackTrace();
                }



            }

        };

        executeThread.start();


    }

    public void shutdown(long mills) {

        long currentTime = System.currentTimeMillis();
        while (!finished){
            if(System.currentTimeMillis() - currentTime >= mills){
                System.out.println("任务超时，需要结束执行进程");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行进程被打断");
                break;
            }

        }

        finished = false;



    }
}
