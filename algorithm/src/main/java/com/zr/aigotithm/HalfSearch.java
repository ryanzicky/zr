package com.zr.aigotithm;

/**
 * @Author zhourui
 * @Date 2021/3/30 15:27
 */
public class HalfSearch {

    public static void main(String[] args) {
        System.out.println(biSearch(new int[]{1, 2, 3, 5, 7, 8, 9, 11}, 6));
    }

    public static int biSearch(int[] arr, int a) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi) {
            mid = (lo + hi) / 2; // 中间位置
            if (arr[mid] == a) {
                return mid + 1;
            } else if (arr[mid] < a) { // 向右查找
                lo = mid + 1;
            } else { // 向左查找
                hi = mid - 1;
            }
        }
        return -1;
    }
}
