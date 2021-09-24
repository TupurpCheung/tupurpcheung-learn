package org.tupurpcheung.learn.jdk.concurrency.chapter4;

/**
 * @author @tupurp
 * @date 2019/3/4 11:12
 * join()的使用
 *
 */
public class TheadJoinAPI2 {

    public static void main(String[] args)throws Exception{
        long  startTimeStamp  = System.currentTimeMillis();

        Thread t1 = new Thread( new CaptureRunnable("M1",10000L));
        Thread t2 = new Thread( new CaptureRunnable("M2",20000L));
        Thread t3 = new Thread( new CaptureRunnable("M3",30000L));


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long  endTimeStamp  = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is : %s,end timestamp is: %s\n",startTimeStamp,endTimeStamp);
    }

}


class CaptureRunnable implements  Runnable{


    private String machineName;
    private long spendTime;

    public CaptureRunnable(String machineName,long spendTime){
        this.machineName = machineName;
        this.spendTime = spendTime;
    }


    @Override
    public void run() {
        //do the really capture thing
        try {
            Thread.sleep(spendTime);
            System.out.printf(machineName + " completed  data capture at timestamp [%s] and successful \n",System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getResult(){

        return machineName + " finish .";
    }
}

