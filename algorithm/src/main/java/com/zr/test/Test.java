package com.zr.test;

/**
 * @Author zhourui
 * @Date 2021/3/13 11:27
 */
/*
public class Test {

    public static void main(String[] args) {
        */
/*5 12 22 35 7*//*

        int[] arr = new int[]{3, 2, 20, 5, 20, 1};
        */
/*找到数组最大的数*//*
*/
/*
        Integer tmp = 0;
        *//*
*/
/*数组中最大数的索引*//*
*/
/*
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tmp.compareTo(arr[i]) < 0) {
                tmp = arr[i];
                index = i;
            }
        }*//*

        int len = arr.length;
        int index = 0;
    }

    public static int getMax(int[] arr, int index, int len) {
        while (len > 0) {
            if (index == 0) {

            }
        }
    }

    public static int getMax(int[] arr, int index, int sum) {
        */
/*1. 甲可以选择第一个位置和最后一个位置的值*//*

        */
/*2. 根据甲的选择，乙可以选择新数组的第一个位置和最后一个位置的值*//*

        */
/*3. 甲根据乙的选择，可以选择剩下新数组的第一个位置和最后一个位置*//*

        while (index > 0 && index < arr.length) {
            if (index - 2 > 0 && index + 2 < arr.length) {
                if ((arr[index] + arr[index - 2]) - (arr[index] + arr[index + 2]) >= 0) {
                    sum += arr[index - 2];
                    index = index - 2;
                    getMax(arr, index, sum);
                } else {
                    sum += arr[index + 2];
                    index = index + 2;
                    getMax(arr, index, sum);
                }
            } else if (index - 2 >= 0) {
                sum += arr[index - 2];
                index = index - 2;
                getMax(arr, index, sum);
            } else if (index + 2 <= arr.length) {
                sum += arr[index + 2];
                index = index + 2;
                getMax(arr, index, sum);
            }
        }
        return sum;
    }

    public static int[] getNewArr(int[] arr, int start, int end) {
        int index = 0;
        getSum(arr, start, end);
        return new int[]{};
    }

    public static int getSum(int[] arr, int index1, int index2) {
        if (index1 == 0) {
            index2 = index1 + 1;

        }
        return 0;
    }


}
*/
