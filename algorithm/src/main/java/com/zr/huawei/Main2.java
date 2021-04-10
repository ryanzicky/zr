package com.zr.huawei;


import java.math.BigInteger;
import java.util.*;

/**
 * @Author zhourui
 * @Date 2021/3/9 22:14
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();

            int index = 0;
            List<BigInteger> list = new ArrayList<>();

            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    list.add(new BigInteger(line.substring(i, i + 1)));
                }
                if (line.charAt(i) == '-') {
                    index = getEnd(i, line.substring(i));
                    BigInteger bigInteger = new BigInteger(line.substring(i, index + 1));
                    list.add(bigInteger);
                    i = index;
                }
            }

            BigInteger sum = new BigInteger("0");
            for (int i = 0; i < list.size(); i++) {
                sum = sum.add(list.get(i));
            }
            System.out.println(sum);
        }
    }

    public static int getEnd(int index, String tmp) {
        for (int i = 0; i < tmp.length(); i++) {
            if (Character.isDigit(tmp.charAt(i))) {
                index++;
            }
        }
        return index;
    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(Long.parseLong(line));
            System.out.println(Long.valueOf(line));
        }
    }*/
}
