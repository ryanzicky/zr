package com.zr.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author zhourui
 * @Date 2021/3/9 21:43
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String test = sc.nextLine();
            HashMap<String, Integer> map = new HashMap<>();
            int index = 0;
            while (index < test.length()) {
                String key = test.substring(index, index + 1);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
                index++;
            }

            int min = Integer.MAX_VALUE;
            for (Integer value : map.values()) {
                min = Math.min(min, value);
            }

            String tmp = test;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == min) {
                    tmp = tmp.replace(entry.getKey(), "").trim();
                }
            }

            if (tmp.length() == 0) {
                System.out.println("empty");
            } else {
                System.out.println(tmp);
            }
        }
    }

}
