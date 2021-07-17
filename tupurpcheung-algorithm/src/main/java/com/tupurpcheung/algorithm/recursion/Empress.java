package com.tupurpcheung.algorithm.recursion;

/**
 * @author zhangxiaoman
 * @Package com.tupurp.learn.algorithm.recursion
 * @Description: 使用递归回溯解决八皇后问题
 *  国际象棋 8×8
 *  棋子彼此 不在同一行、同一列、同一斜线
 *
 * @date 2020/6/10 12:35
 */
public class Empress {


    private int solution = 0;

    /**
     * 棋盘最大行、列 < max
     * */
    private int max = 8;
    /**
    * 棋盘
     * 数组下标为行
     * 元素值为列
    * */
    private int[] map = new int[max];



    /**
     * 下棋 n:棋子在第几行移动
     * 递归
     * 回溯使用for循环实现
     * */
    public void chess(int n){
        //已找到解法
        if(n == max){
            showSolution();
            return;
        }
        for(int i = 0;i < max;i++){
            //将棋盘的第（n+1）行 从第1列依次放到max-1列
            map[n] = i;
            //检查该位置是否冲突,不冲突，放下一行
            if(check(n)){

                chess(n+1);
            }
        }
        //如果冲突，执行循环，即将第N行的皇后在本行后移一个位置（即改变列）

    }

    /**
     * 检查棋子放下的位置是否冲突
     * */
    private boolean check(int n){

       for(int i=0;i < n;i++){
           //在同一列或在同一斜线，返回false
            if(map[i] == map[n] || Math.abs(n-i) == Math.abs(map[n] - map[i])){
               return false;
            }
       }
       return true;
    }

    /**
     * 查看解法
     * */
    private void showSolution(){
        for(int i=0;i < max;i++){

            System.out.print(map[i] + "\t");
        }
        solution++;
        System.out.println();
    }

    public int getSolution(){
        return solution;
    }

    public static void mainTest(String [] args){
        Empress empress = new Empress();
        empress.chess(0);
        System.out.printf("共有%d种解法",empress.getSolution());
    }

}
