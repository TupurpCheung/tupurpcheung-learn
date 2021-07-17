package com.tupurpcheung.java.concurrency.chapter3;

/**
 * @author @tupurp
 * @date 2019/3/1 17:25
 * 创建一个我们可以控制        虚拟机栈大小的线程
 * 构造Thread的时候传入stackSize代表着该线程占用的虚拟机栈 stack的大小，如果没有指定stackSize的大小，默认
 * 是0，0代表着会忽略该参数，该参数会被JNI函数去使用。
 * 需要注意：该参数有一些平台有效，有些平台无效
 * 所以建议使用虚拟机启动参数指定
 * -Xss10M
 *
 */
public class CreateThread4 {


    private static int counter = 1;

    public static void main(String[] args) {
        Thread t = new Thread(null,new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    e.printStackTrace();
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }

        ,"TestThreadStackSize",1 << 24);
    t.start();
    }

}
