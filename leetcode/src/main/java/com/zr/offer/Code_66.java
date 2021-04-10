package com.zr.offer;

/**
 * 剑指 Offer 66. 构建乘积数组
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * @Author zhourui
 * @Date 2021/4/9 10:11
 */
public class Code_66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[]{0};
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        Code_66 code_66 = new Code_66();
        int[] ints = code_66.constructArr(new int[]{1, 2, 3, 4, 5});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
