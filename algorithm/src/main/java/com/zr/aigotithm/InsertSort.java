package com.zr.aigotithm;

/**
 * @Author zhourui
 * @Date 2021/3/30 15:48
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 7, 4, 2};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 插入的数
            int insertVal = arr[i];
            // 被插入的位置(准备和前一个数比较)
            int index = i - 1;
            // 如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]) {
                // 将把arr[index]向后移动
                arr[index + 1] = arr[index];
                // 让index向前移动
                index--;
            }
            // 把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
    }
}
