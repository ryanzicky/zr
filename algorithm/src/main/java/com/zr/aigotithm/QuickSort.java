package com.zr.aigotithm;

/**
 * @Author zhourui
 * @Date 2021/3/30 16:40
 */
public class QuickSort {

    public static void main(String[] args) {

    }

    public static void sort(int[] arr, int lo, int hi) {
        int start = lo;
        int end = hi;

        int key = arr[lo];
        while (end > start) {
            // 从后往前比较
            while (end > start && arr[end] >= key) {
                // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
                if (arr[end] <= key) {
                    int temp = arr[end];
                    arr[end] = arr[start];
                    arr[start] = temp;
                }
            }

            // 从前往后比较
            while (end > start && arr[start] <= key) {
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
                if (arr[start] >= key) {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                }
            }
            // 此时第一次循环结束，关键值的位置已经确定了，左边的值都比关键值小，右边的值都比关键值大
            // 但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        if (start > lo) {
            sort(arr, lo, start - 1); // 左边序列，第一个索引位置到关键值索引 - 1
        }
        if (end < hi) {
            sort(arr, end + 1, hi); // 右边序列，从关键值索引 + 1到最后一个
        }
    }
}
