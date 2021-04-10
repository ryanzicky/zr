package com.zr.leetcode;

import java.util.HashMap;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * @Author zhourui
 * @Date 2021/3/24 9:09
 */
public class Code_01 {

    public static void main(String[] args) {
        int[] ints = {2, 7, 13, 15};
        int[] ints1 = twoSum2(ints, 9);
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * hashMap
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>(len - 1);
        hashMap.put(nums[0], 0);

        for (int i = 0; i < len - 1; i++) {
            int another = target - nums[i];
            if (hashMap.containsKey(another)) {
                return new int[]{hashMap.get(another), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
