package com.zr.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2021/3/13 13:21
 */
public class Main2 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 20, 5};
        /*获取甲能取得的最大值*/
        int sum = getMaxSum(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        System.out.println(sum);

        int[] arr1 = new int[]{5, 12, 35, 22, 7};
        /*获取甲能取得的最大值*/
        int sum1 = getMaxSum(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println(" ");
        System.out.println(sum1);
    }

    public static int getMaxSum(int[] arr) {
        /*设置游标1，起点为第一个数字*/
        int index1 = 0;
        /*设置游标2，起点为最后一个数字*/
        int index2 = arr.length - 1;
        int sum = 0;
        /*当游标1大于游标2时，中断计算*/
        while (index1 <= index2) {
            /*比较两个游标对应值，获取大值*/
            int maxIndex = getMax(arr, index1, index2);
            /*1为正向循环*/
            if (maxIndex == 1) {
                sum += arr[index1];
                if (arr[index1 + 1] > arr[index2]) {
                    index1 += 2;
                } else {
                    index2 -= 1;
                    index1 += 1;
                }
                /*非1为逆向循环*/
            } else {
                sum += arr[index2];
                if (arr[index2 - 1] > arr[index1]) {
                    index2 -= 2;
                } else {
                    index1 += 1;
                    index2 -= 1;
                }
            }
        }
        return sum;
    }

    /**
     * 比较数组第一个索引值和最后索引值
     * 1为第一个索引的值大，2为最后索引的值大
     *
     * @param arr
     * @param index1
     * @param index2
     * @return
     */
    public static int getMax(int[] arr, int index1, int index2) {
        /*当下一次取值超出当前数组长度时，取边界数字*/
        if ((index1 + 2) >= arr.length || (index2 - 2) <= 0) {
            if (arr[index1] >= arr[index2]) {
                return 1;
            } else {
                return 2;
            }
        } else  {
            /*没超出数组长度时，比较当前值+下一步的值*/
            if (arr[index1] + arr[index1 + 2] >= arr[index2] + arr[index2 - 2]) {
                return 1;
            } else {
                return 2;
            }
        }

    }
}
