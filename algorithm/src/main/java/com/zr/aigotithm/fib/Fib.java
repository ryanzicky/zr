package com.zr.aigotithm.fib;

import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2021/4/18 20:45
 */
public class Fib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }

            if (n <= 2) {
                arr[n - 1] = 1;
            } else {
                for (int i = 3; i <= n; i++) {
                    arr[i - 1] = arr[i - 2] + arr[i - 3];
                }
            }
            System.out.println(arr[n - 1]);
        }
    }
}
