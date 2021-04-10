package com.zr.aigotithm;

/**
 * @Author zhourui
 * @Date 2021/4/8 10:42
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (Integer.MAX_VALUE != minNum && prices[i] - minNum > maxProfit) {
                maxProfit = prices[i] - minNum;
            }

            if (prices[i] < minNum) {
                minNum = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] arr = {7, 1, 5, 3, 6, 4};
        int[] arr1 = {7, 6, 4, 3, 1};
//        System.out.println(maxProfit.maxProfit(arr));

        System.out.println(maxProfit.maxProfit2(arr));
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i != 0 && prices[i] - prices[i - 1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
