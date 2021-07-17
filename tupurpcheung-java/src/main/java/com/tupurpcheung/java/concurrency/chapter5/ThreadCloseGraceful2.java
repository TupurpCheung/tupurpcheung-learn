package com.tupurpcheung.java.concurrency.chapter5;

/**
 * @author @tupurp
 * @date 2019/3/4 14:15
 * <p>
 * 关闭线程方式2：捕获线程中断信号
 */
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {

        @Override
        public void run() {
            //方式1：直接退出
//            while (true){
//                try {
//                    Thread.sleep(1);
//
//
//                    if(Thread.interrupted()){
////                        //处理逻辑
////                        break;
////                    }
//                } catch (InterruptedException e) {
//
//                    break;
//                }
//            }


            //方式2：在退出前还有逻辑需要处理
            while (true) {

                if (Thread.interrupted()) {
                    break;
                }
            }

            //处理逻辑
            //-------TODO
            //-------TODO

        }

    }

    public static void main(String[] args) {

        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        worker.interrupt();


    }

}
