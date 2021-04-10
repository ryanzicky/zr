package com.zr.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zhourui
 * @Date 2021/3/10 13:56
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("exit")) {
                break;
            }
            list.add(Integer.parseInt(line));
        }

        int index1 = 0;
        int index2 = list.size() - 1;
        int sum = 0;
        while (index1 < index2) {
            int maxIndex = getMax(list, index1, index2);
            if (maxIndex == 1) {
                sum += list.get(index1);
                index1 += 2;
            } else {
                sum += list.get(index2);
                index2 -= 2;
            }
        }
        System.out.println(sum);
    }

    public static int getMax(List<Integer> list, int index1, int index2) {
        if ((index1 + 2) >= list.size() || (index2 - 2) <= 0) {
            if (list.get(index1) >= list.get(index2)) {
                return 1;
            } else {
                return 2;
            }
        } else  {
            if (list.get(index1) + list.get(index1 + 2) >= list.get(index2) + list.get(index2 - 2)) {
                return 1;
            } else {
                return 2;
            }
        }

    }
}
