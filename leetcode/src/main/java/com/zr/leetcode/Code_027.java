package com.zr.leetcode;

/**
 * @Author zhourui
 * @Date 2021/3/29 17:31
 */
public class Code_027 {

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
