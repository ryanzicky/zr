package com.zr.leetcode;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @Author zhourui
 * @Date 2021/3/24 10:32
 */
public class Code_14 {

    public static void main(String[] args) {

    }

    /**
     * 横向扫描
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 0; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String prefix, String str) {
        int length = Math.min(prefix.length(), str.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == str.charAt(index)) {
            index ++;
        }
        return prefix.substring(0, index);
    }

}