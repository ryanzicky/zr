package com.zr.huawei;


import java.util.*;

/**
 * @Author zhourui
 * @Date 2021/3/3 11:18
 */
public class Main {

    /**
     * 最后一个字符串长度
     */
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        System.out.println(getLastStrLen(test));
    }

    public static int getLastStrLen(String test) {
        if (StringUtils.isBlank(test)) {
            return 0;
        }
        String[] split = test.split(" ");
        String last = split[split.length - 1];
        return last.length();
    }*/


    /**
     * 找出对应字符在字符串中出现次数
     */
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        System.out.println(getStrShowTimes(line1, line2));
    }

    public static int getStrShowTimes(String test1, String test2) {
        String s = test1.toLowerCase();
        String s1 = test2.toLowerCase();

        return s.length() - s.replace(s1, "").length();
    }*/

    /**
     * 输入多组随机数，去重并排序
     */
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeSet<Integer> integers = new TreeSet<>();
            Integer num = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                integers.add(scanner.nextInt());
            }
            Iterator<Integer> iterator = integers.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float v = (float) sc.nextLine().length() / 8;
        System.out.println(v);
        System.out.println(Math.ceil(v));
    }*/

    /**
     * 输入字符串，按固定长度拆分，不足固定长度补0
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "00000000";
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String tmp = line;
            int ceil = (int) Math.ceil((float) line.length() / 8);
            System.out.println(ceil);
            for (int i = 0; i < ceil; i++) {
                if (tmp.length() > 8) {
                    String substring = tmp.substring(0, 8);
                    tmp = tmp.substring(8);
                    System.out.println(substring);
                } else if (tmp.length() == 8){
                    System.out.println(tmp);
                    tmp = tmp.substring(8);
                } else {
                    System.out.println(tmp + a.substring(0, 8 - tmp.length()));;
                    tmp = tmp.substring(tmp.length());
                }
            }
        }
    }*/


    /**
     * 接受一个十六进制的数，输出该数值的十进制表示。
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(Integer.parseInt(line.replaceAll("0x", ""), 16));
        }
    }*/

    /**
     * 输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     *
     * 最后一个数后面也要有空格
     * @param args
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();

        int i = 2;
        int i1 = (int) Math.sqrt(num) + 1;
        while (num != 1 && i <= i1) {
            if (num % i == 0) {
                num /= i;
                System.out.print(i + " ");
                i = 2;
            } else {
                i++;
            }
        }
        if (i > i1) {
            System.out.print(num + " ");
        }
        sc.close();
    }*/

    /**
     * 近似值
     * @param args
     */
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigDecimal bigDecimal = scanner.nextBigDecimal();
            System.out.println(bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP));
        }
    }*/

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(s);
        }
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aa = sc.nextLine();
        System.out.println(aa);
        Map<Integer, Integer> map = new HashMap<>();
        sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            Integer index = Integer.valueOf(split[0]);
            Integer value = Integer.valueOf(split[1]);
            if (null == map.get(index)) {
                map.put(index, value);
            } else {
                Integer tmp = map.get(index);
                map.put(index, tmp + value);
            }
        }
        map.entrySet().forEach(v -> {
            System.out.println(v.getKey() + " " + v.getValue());
        });
    }

}
