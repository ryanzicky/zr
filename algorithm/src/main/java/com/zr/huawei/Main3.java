package com.zr.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2021/3/10 10:41
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.nextLine();
            a = a.replaceAll("\\+", "").replaceAll("[a-zA-Z]+", "k").replaceAll("[k]+", "k") + "k";
            System.out.println(Arrays.toString(a.split("")));;
            String[] split = a.split("");

            int leftIndex = 0;
            int rightIndex = 0;
            boolean fushu = false;
            int total = 0;

            while (rightIndex < split.length) {
                String now = split[rightIndex];

                if ("-".equals(now) || "k".equals(now)) {
                    total += getSum(fushu, leftIndex, rightIndex, a);
                    rightIndex ++;
                    leftIndex = rightIndex;
                    if ("-".equals(now)) {
                        fushu = true;
                    }
                    if ("k".equals(now)) {
                        fushu = false;
                    }

                } else {
                    rightIndex ++;
                }
            }
            System.out.println(total);
        }
    }

    private static int getSum(boolean fushu, int leftIndex, int rightIndex, String a) {
        if (leftIndex == rightIndex || a.substring(leftIndex, rightIndex).equals("-") || a.substring(leftIndex, rightIndex).equals("k")) {
            return 0;
        }
        if (fushu) {
            return Integer.parseInt(a.substring(leftIndex, rightIndex)) * (-1);
        } else {
            return Arrays.stream(a.substring(leftIndex, rightIndex).split("")).map(c -> Integer.parseInt(c)).reduce((c, d) -> c + d).get();
        }
    }
}
