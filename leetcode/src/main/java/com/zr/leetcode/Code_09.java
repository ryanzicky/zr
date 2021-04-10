package com.zr.leetcode;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @Author zhourui
 * @Date 2021/3/24 10:05
 */
public class Code_09 {

    public static void main(String[] args) {
        System.out.println(isPalinedrome(123));
        System.out.println(isPalinedrome(12321));
    }

    public static boolean isPalinedrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
            if (x == n || x / 10 == n) {
                return true;
            }
        }
        return  x == n || x == n / 10;
    }
}
