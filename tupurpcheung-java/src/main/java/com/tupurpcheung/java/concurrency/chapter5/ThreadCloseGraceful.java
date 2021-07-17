package com.tupurpcheung.java.concurrency.chapter5;

/**
 * @author @tupurp
 * @date 2019/3/4 14:09
 *
 * 关闭线程方式1：开关
 *
 */
public class ThreadCloseGraceful {



    private static class Worker extends Thread{

        private volatile boolean start = true;

        @Override
        public void run(){

            while (start){
                //
            }

        }

        public void shutdown(){
            this.start = false;
        }


    }

    public static void main(String [] args){
        Worker  worker = new Worker();
        worker.start();
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        worker.shutdown();

    }



}
