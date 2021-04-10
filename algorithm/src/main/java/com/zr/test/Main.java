package com.zr.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2021/3/13 13:21
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            /*获取输入值，生成测试数组*/
            Scanner sc = new Scanner(System.in);
            List<Integer> list = new ArrayList<>();
            while (sc.hasNext()) {
                String line = sc.nextLine();
                /*当输入值为exit时，中断输入，开始执行第一次数组计算*/
                if (line.equals("exit")) {
                    break;
                }
                list.add(Integer.parseInt(line));
            }
            /*获取甲能取得的最大值*/
            int sum = getMaxSum(list);
            System.out.println(sum);

        }
    }

    public static int getMaxSum(List<Integer> list) {
        /*设置游标1，起点为第一个数字*/
        int index1 = 0;
        /*设置游标2，起点为最后一个数字*/
        int index2 = list.size() - 1;
        int sum = 0;
        /*当游标1大于游标2时，中断计算*/
        while (index1 <= index2) {
            /*比较两个游标对应值，获取大值*/
            int maxIndex = getMax(list, index1, index2);
            /*1为正向循环*/
            if (maxIndex == 1) {
                sum += list.get(index1);
                if (list.get(index1 + 1) > list.get(index2)) {
                    index1 += 2;
                } else {
                    index2 -= 1;
                    index1 += 1;
                }
                /*非1为逆向循环*/
            } else {
                sum += list.get(index2);
                if (list.get(index2 - 1) > list.get(index1)) {
                    index2 -= 2;
                } else {
                    index1 += 1;
                    index2 -= 1;
                }
            }
        }
        return sum;
    }

    public static int getMax(List<Integer> list, int index1, int index2) {
        /*当下一次取值超出当前数组长度时，取边界数字*/
        if ((index1 + 2) >= list.size() || (index2 - 2) <= 0) {
            if (list.get(index1) >= list.get(index2)) {
                return 1;
            } else {
                return 2;
            }
        } else  {
            /*没超出数组长度时，比较当前值+下一步的值*/
            if (list.get(index1) + list.get(index1 + 2) >= list.get(index2) + list.get(index2 - 2)) {
                return 1;
            } else {
                return 2;
            }
        }

    }
}
