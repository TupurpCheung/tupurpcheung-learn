package com.tupurpcheung.java.concurrency.chapter9;

/**
 * @author @tupurp
 * @date 2019/3/5 12:02
 * 通过Runtime.getRuntime().addShutdownHook 可以捕获到 程序被杀死，从而做些释放资源的操作，但对Kill -9 pid 无效
 *
 * javac public class ExitCapture.java
 * nohup java -cp . ExitCapture &
 *
 */
public class ExitCapture{

    public static void main(String [] args){

        //Runtime 可以执行很多命令
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The application will be exit.");
            notifyAndRelease();

        }));

//		int i = 0;

        while(true){
            try{

                Thread.sleep(1_100L);

                System.out.println("I am working...");


            }catch(Throwable e){
                //ignore
            }


//			i++;
//			if(i>20){
//				throw new RuntimeException("Error");
//			}
        }

    }

    private static void notifyAndRelease(){

        System.out.println("notify to the admin");
        try{
            Thread.sleep(1_000);
        }catch(Throwable e){
        }

        System.out.println("will relase resource(socket,file,connection.)");

        try{
            Thread.sleep(1_000);
        }catch(Throwable e){}

        System.out.println("Release and notify end.");


    }

}
