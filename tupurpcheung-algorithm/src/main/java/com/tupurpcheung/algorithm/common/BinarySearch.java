package com.tupurpcheung.algorithm.common;

/**
 * @description: 二分查找（非递归实现）
 * @author: tupurp
 * @create: 2020-06-29 21:25
 */
public class BinarySearch {

    public static void mainTest(String[] args){
        int[] arr = {1,3,8,14,25,68,87,99};
        int index = binarySearch(arr,1);
        System.out.println("index=" + index);
    }

    /**
     * @param arr 待查找的数组（升序）
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     * */
    public static  int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == arr[mid]){
                return mid;
            }else
            //中间值大于目标值，向左查找
            if(target < arr[mid]){
                right = mid - 1;
            }else
            //中间值小于目标值，向右查找
            {
                left = mid + 1;
            }
        }

        return -1;
    }
}