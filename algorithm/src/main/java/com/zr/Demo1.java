package com.zr;

import lombok.Data;

/**
 * @Author zhourui
 * @Date 2021/1/23 16:37
 */
public class Demo1 {

    public static void main(String[] args) {

        System.out.println("sssss1");
        //        int ways = ways1(4, 2, 4, 4);
//        System.out.println("ways = " + ways);;
    }

    /**
     *
     * @param N 几条路
     * @param start 在哪
     * @param aim 目标
     * @param K 步数
     * @return
     */
    public static int ways1(int N, int start, int aim, int K) {
        return process1(start, K, aim, N);
    }

    /**
     * 机器人当前来到的位置是cur
     *
     * @param cur 当前位置
     * @param rest 还有多少步
     * @param aim 最终目标aim
     * @param N 有哪些位置1~N
     * @return 返回机器人从cur出发，走过rest步后，最终停在aim的方法数是多少
     */
    public static int process1(int cur, int rest, int aim, int N) {
        /*剩余步数为0*/
        if (rest == 0) {
            /*当前所在位置是终点位置*/
            return cur == aim ? 1 : 0;
        }
        /*当前位置为1,下一步为2*/
        if (cur == 1) {
            return process1(2, rest - 1, aim, N);
        }
        /*当前位置为N,下一步为N-1*/
        if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        /*中间位置*/
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }

    /**
     *
     * @param N 几条路
     * @param start 在哪
     * @param aim 目标
     * @param K 步数
     * @return
     */
    public static int ways2(int N, int start, int aim, int K) {
        return process1(start, K, aim, N);
    }

    /**
     * 机器人当前来到的位置是cur
     *
     * @param cur 当前位置
     * @param rest 还有多少步
     * @param aim 最终目标aim
     * @param N 有哪些位置1~N
     * @return 返回机器人从cur出发，走过rest步后，最终停在aim的方法数是多少
     */
    public static int process2(int cur, int rest, int aim, int N) {
        /*剩余步数为0*/
        if (rest == 0) {
            /*当前所在位置是终点位置*/
            return cur == aim ? 1 : 0;
        }
        /*当前位置为1,下一步为2*/
        if (cur == 1) {
            return process2(2, rest - 1, aim, N);
        }
        /*当前位置为N,下一步为N-1*/
        if (cur == N) {
            return process2(N - 1, rest - 1, aim, N);
        }
        /*中间位置*/
        return process2(cur - 1, rest - 1, aim, N) + process2(cur + 1, rest - 1, aim, N);
    }
}
