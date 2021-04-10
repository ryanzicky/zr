package com.zr.leetcode;

import java.util.Scanner;

/**
 * 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @Author zhourui
 * @Date 2021/3/24 9:43
 */
public class Code_07 {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int neg = x < 0 ? -1 : 1;
        x *= neg;
        int ret = 0;
        while (x > 0) {
            int n = ret;
            n *= 10;
            n += x % 10;
            x /= 10;
            if (n / 10 != ret) {
                return 0;
            }
            ret = n;
        }
        return ret * neg;
    }
}
