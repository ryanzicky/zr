package com.zr.aigotithm;

/**
 * @Author zhourui
 * @Date 2021/3/30 15:33
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 6, 3, 8, 11, 9};
        bubbleSort(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort(int[] arr, int n) {
        int i, j;
        for (i = 0; i < n; i++) { // 表示n次排序过程
            for (j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) { // 前面的数字大于后面的数字就交换
                    // 交换arr[j - 1]和arr[j]
                    int temp;
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
