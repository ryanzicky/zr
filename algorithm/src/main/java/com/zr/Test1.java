package com.zr;

/**
 * @Author zhourui
 * @Date 2021/2/5 15:46
 */
public class Test1 {

    public static void main(String[] args) {
        String way = "UD";
        System.out.println(process(way));;

        String way1 = "LL";
        System.out.println(process(way1));
    }

    /**
     * U = 1
     * D = 1
     * L = 2
     * R = 2
     * @param way
     */
    private static boolean process(String way) {
        char[] chars = way.toCharArray();
        int eor = 0;
        int tmp = 0;
        for (char aChar : chars) {
            eor = eor ^ convert(aChar);
            tmp += convert1(aChar);
        }
        return eor == 0 && tmp == 0;
    }

    private static int convert1(char c) {
        switch (c) {
            case 'U':
                return 1;
            case 'D':
                return -1;
            case 'L':
                return 2;
            case 'R':
                return -2;
            default:
                return 0;
        }
    }

    private static int convert(char c) {
        switch (c) {
            case 'U':
                return 1;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 2;
            default:
                return 0;
        }
    }
}
