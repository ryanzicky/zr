package com.zr.leetcode;

import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2021/4/7 17:57
 */
public class Code_058 {

    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (split.length == 0) {
            return 0;
        }
        String tmp = split[split.length - 1];
        return tmp.length();
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord(" "));
    }
}
