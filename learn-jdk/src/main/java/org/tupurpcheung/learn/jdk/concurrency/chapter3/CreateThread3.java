package org.tupurpcheung.learn.jdk.concurrency.chapter3;

/**
 * @author @tupurp
 * @date 2019/3/1 16:49
 * <p>
 * Thread构造方法   java 的JVM（java虚拟机） 的组成 和  线程  栈大小 （stackSize） 的关系
 * main 线程是jvm启动的，所以我们没办法设定其栈大小
 * <p>
 * <p>
 * ******************            ********************          *****************
 * *   方法区       *            *   虚拟机栈       *          * 本地方法栈    *
 * *****************             ********************          *****************
 * <p>
 * <p>
 * ***************************************                      *****************
 * *            堆                       *                      * 程序计数器    *
 * **************************************                       *****************
 * <p>
 * <p>
 * <p>
 * ********************                          **********************
 * *    执行引擎      *                          *     本地方法库     *
 * ********************                          **********************
 */
public class CreateThread3 {


    /**
     * i 方法区
     */
    private int i = 0;

    /**
     * bytes  4个子节，32位，方法区
     * new bytes[1024]  堆
     */
    private byte[] bytes = new byte[1024];


    private static int counter = 0;

    /**
     * jvm will create a thread named "main"   java虚拟机创建一个线程名称叫做main
     */
    public static void main(String[] args) {

        /**create a JVM stack 创建一个虚拟机栈*/

        /**
         * 局部变量放入 虚拟机栈的 局部变量表中
         */
        int i = 0;

        /**
         * arr  放入 虚拟机栈的 局部变量表中
         * new bytes[1024]  堆
         */
        byte[] arr = new byte[1024];


        /**
         * java.lang.StackOverFlowError
         *
         *
         * */
        try {

            /**
             * 执行了多少次，就向虚拟机栈内压入了多少个栈帧
             *
             * */
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(counter);
        }


    }

    /**
     * 死循环，不断的向虚拟机栈内压栈帧
     */
    private static void add(int i) {
        counter++;
        add(i + 1);
    }

}
