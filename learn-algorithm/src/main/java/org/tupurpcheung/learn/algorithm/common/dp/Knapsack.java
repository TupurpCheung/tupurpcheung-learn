package org.tupurpcheung.learn.algorithm.common.dp;

import java.util.Arrays;

/**
 * @description: 动态规划之01背包
 * @author: tupurp
 * @create: 2020-07-02 22:31
 */
public class Knapsack {

    public static void mainTest(String[] args){
        //背包容量 4
         int volume = 4;
        //物品重量
         int[] wight = {1,4,3};
        //物品价值
         int[] value = {1500,3000,2000};
        //物品的个数
         int count = value.length;
        //二维数组v[i][j]表示在前i个物品中，能够装入容量为volume的背包的物品总计最大价值
         int[][] v = new int[count+1][volume+1];
         int[][] path = new int[count+1][volume+1];
         initArr(v);
         dp(v,path,wight,value);
         showArr(v);
        showPath(path,wight);
    }




    private static void initArr(int[][] v){
        //第一列设置为0
        for(int i=0;i<v.length;i++){
            v[i][0] = 0;
        }
        //第一行设置为0
        for(int i=0;i<v[0].length;i++){
            v[0][i] = 0;
        }
    }

    /**
     * @param v
     * @param path 记录哪些物品被放进了背包
     * @param weight 重量
     * @param value 价值
     * */
    private static void dp(int[][] v,int[][] path,int[] weight,int[] value){
        int row = v.length;
        int column = v[0].length;
        for(int i=1;i<row;i++){
            //背包重量为j时可放下的最大价值
            for(int j=1;j<column;j++){
                if(weight[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    //v[i][j] = Math.max(v[i-1][j],value[i-1] + v[i-1][j - weight[i-1]]);
                    if(v[i-1][j] < value[i-1] + v[i-1][j - weight[i-1]]){
                        v[i][j] = value[i-1] + v[i-1][j - weight[i-1]];
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i-1][j];
                    }
                }
            }

        }
    }

    private static void showArr(int[][] v){
        for(int[] arr:v){
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void showPath(int[][] path,int[] weight){
        int row = path.length - 1;
        int column = path[0].length - 1;
        while (row > 0 && column > 0){
            if(path[row][column] == 1){
                System.out.printf("第%d个物品放入到背包\n",row);
                column -= weight[row -1];
            }
            row--;
        }
    }

}