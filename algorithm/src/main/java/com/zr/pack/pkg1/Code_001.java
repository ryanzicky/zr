package com.zr.pack.pkg1;

/**
 *
 * @Author zhourui
 * @Date 2021/2/5 10:14
 */
public class Code_001 {

    public static void main(String[] args) {
        /*两个数交换*/
        /*int a = 13;
        int b = 23;
        swap(a, b);*/

        /*数组中两个数交换*/
        /*int[] c = {3, 1, 100};
        swap1(c);*/

        int[] arr = {4, 1, 1, 2, 3, 2, 3, 3, 1, 1, 3, 4, 4};
        swap2(arr);
    }

    /*交换数组两位数字*/
    private static void swap1(int[] c) {
        int a = 0;
        int b = 1;

        swap(c[a], c[b]);
    }

    /*异或运算交换两个*/
    private static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /*一个数组中一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数*/
   private static void swap2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
       System.out.println(eor);
   }
}
