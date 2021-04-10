package com.zr.leetcode;

import java.util.Arrays;

/**
 * @Author zhourui
 * @Date 2021/4/7 19:05
 */
public class Code_66 {

    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) {
            return digits;
        }
        int one = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int i1 = digits[i] + one;
            digits[i] = i1 % 10;
            one = i1 / 10;
        }
        if (one == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        Code_66 code_66 = new Code_66();
        System.out.println(Arrays.toString(code_66.plusOne(new int[]{4, 3, 2, 9})));
        System.out.println(Arrays.toString(code_66.plusOne(new int[]{9, 9, 9, 9})));
    }
}
