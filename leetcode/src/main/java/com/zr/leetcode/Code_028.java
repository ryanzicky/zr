package com.zr.leetcode;

/**
 * @Author zhourui
 * @Date 2021/3/29 17:35
 */
public class Code_028 {

    public static void main(String[] args) {
        strStr("hello", "ll");
    }

    public static int strStr(String haystack, String needle) {
        int l = needle.length();
        int n = haystack.length();

        for (int start = 0; start < n - l + 1; start++) {
            if (haystack.substring(start, start + l).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
