package com.tupurpcheung.algorithm.common;

/**
 * @description: 汉诺塔（使用分治）
 * @author: tupurp
 * @create: 2020-06-29 22:14
 */
public class HanoiTower {

    public static void mainTest(String[] args){
        hanoiTower(3,'A','B','C');
    }

    /**
     * 汉诺塔的移动方法（使用分治）
     * @param num 需要移动几个盘
     * @param source 被移动的塔
     * @param temp 临时借用塔
     * @param target 移动目标塔
     *
     * */
    public static void hanoiTower(int num,char source,char temp,char target){
        if(num == 1){
            System.out.println( source + "塔第1个盘-->" + target + "塔");
        }else{
            //如果是n >= 2的情况，总是需要把最下面的一个盘看作一个盘，最下面一个盘上面的所有盘看作一个整体（一个盘）
            //1：先把上面的所有盘 source --> temp,移动过程种会借用target
            hanoiTower(num -1,source,target,temp);
            //2:把最下边的盘 source --> target

            System.out.println( source + "塔第" + num + "个盘-->" + target + "塔");
            //3：temp塔的所有盘 temp --> target,移动过程种会借用source塔
            hanoiTower(num - 1,temp,source,target);
        }
    }
}