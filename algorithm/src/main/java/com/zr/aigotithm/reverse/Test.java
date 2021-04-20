package com.zr.aigotithm.reverse;

import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2021/4/15 16:06
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(line);

            line = reverse(line);
            System.out.println(line);

        }
    }

    public static String reverse(String str) {
        int start = 0, end = str.length() - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.indexOf(i) == '"') {
                end = i;
                break;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(i) == '"') {
                start = i;
                break;
            }
        }
        if (start != end) {
            String substring = str.substring(start, end);
            System.out.println(substring);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
