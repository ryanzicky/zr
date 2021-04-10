package com.zr.leetcode;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Author zhourui
 * @Date 2021/3/24 11:03
 */
public class Code_26 {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
         for (int j = 0; j < nums.length; j++) {
             if (nums[j] != nums[i]) {
                 i++;
                 nums[i] = nums[j];
             }
         }
         return i + 1;
    }
}
