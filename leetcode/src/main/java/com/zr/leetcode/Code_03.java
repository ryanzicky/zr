package com.zr.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 输入：bbbbb  输出：1
 *
 * @Author zhourui
 * @Date 2021/4/7 22:09
 */
public class Code_03 {

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第i到rk个字符是一个极长的无重复字符串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Code_03 code_03 = new Code_03();
//        System.out.println(code_03.lengthOfLongestSubstring("abcabcaa"));
        System.out.println(code_03.lengthOfLongestSubstring("abbccdba"));
    }
}
