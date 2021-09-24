package org.tupurpcheung.learn.jdk.concurrency.chapter1;

/**
 * @author @tupurp
 * @date 2019/2/27 14:46
 */
public class TryConcurrency {


    /**顺序执行*/
    public static  void main(String[] args){

        new Thread("READ-THREAD"){
            @Override
            public void run(){
                readFromDataSourceBase();
            }
        }.start();

        new Thread("WRITE-THREAD"){
            @Override
            public void run(){
                writeDataToFile();
            }
        }.start();


//        Thread thread_One = new Thread("thread_one"){
//
//            @Override
//            public void run(){
//                for (int i = 0; i < 100 ; i++) {
//                    println("Task i=>" + i);
//
//                    try {
//                        Thread.sleep(1000L);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        };
//
//        thread_One.start();


//        try{
//            /**
//             * jps 得到进程号
//             * jconsole 进程号
//             *
//             * */
//            Thread.sleep(1000*300L);
//
//
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }

//        for (int i = 0; i <100 ; i++) {
//            println("Task i=>" + i);
//        }
//
//
//        for (int i = 0; i <100 ; i++) {
//            println("Task j=>" + i);
//        }
//
//        readFromDataSourceBase();
//        writeDataToFile();
    }

    /**模拟从数据库读取数据*/
    private static  void readFromDataSourceBase(){

        try{
            println("Begin read data from db.");
            Thread.sleep(1000*20L);
            println("Read data done and start handle it.");

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        println("the data handle finish and successfully.");
    }

    private static  void writeDataToFile(){
        try{
            println("Begin write data to file.");
            Thread.sleep(1000*20L);
            println("Write data done and start handle it.");

        }catch(InterruptedException e){
            e.printStackTrace();
        }

        println("the data handle finish and successfully.");
    }

    private static  void println(String message){
        System.out.println(message);
    }

}
