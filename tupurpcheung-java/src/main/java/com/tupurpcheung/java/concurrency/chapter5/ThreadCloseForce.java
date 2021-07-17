package com.tupurpcheung.java.concurrency.chapter5;

/**
 * @author @tupurp
 * @date 2019/3/4 14:23
 *
 * 一直阻塞在读取（网络资源，本地资源，耗时得操作），没办法获取开关状态，也没有机会捕捉到中断异常
 * 关闭线程方式3:
 */
public class ThreadCloseForce {


    public static void main(String[] args) {

        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.execute(()->{

            //load a very heavy resource
                while (true){

                }

        });

        threadService.shutdown(10000);
        long end = System.currentTimeMillis();

        System.out.println(end-start);


    }
}
