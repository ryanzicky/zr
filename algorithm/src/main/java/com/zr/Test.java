package com.zr;

/**
 * @Author zhourui
 * @Date 2021/1/25 11:43
 */
public class Test {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

//        int[] gas = { 2, 3, 4};
//        int[] cost = {3, 4, 3};

        long start = System.currentTimeMillis();
        Node head = new Node(gas[0], 0, cost[0]);
        for (int i = 1; i <= gas.length; i++) {
            if (i == gas.length) {
                Node node = head.getNode(head, i - 1);
                head.addNode(node, head);
            } else {
                Node node = new Node(gas[i], i, cost[i]);
                head.addNode(head, node);
            }
        }
        for (int i = 0; i < gas.length; i++) {
            int used = 0;
            System.out.println(ways(head, i, used, 0, i, gas));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static int ways(Node head, int N, int used, int num, int start, int[] gas) {
        Node node = head.getNode(head, N);
        if (num == 0) {
            used += node.gas;
        } else {
            used += node.gas - node.pre.cost;
        }
        if (used < 0 || used < node.cost) {
            return -1;
        }
        if (num == gas.length) {
            return start;
        }
        num ++;
        return ways(head, node.next.index, used, num, start, gas);
    }

    /*private static int convert(int N, int[] gas) {
        if (N >= gas.length) {
            return 0;
        }
        return N;
    }

    private static int ways(int[] gas, int[] cost, int N) {
        return gas[convert(N, gas)] - cost[convert(N, gas)] + gas[convert(N + 1, gas)] - cost[convert(N + 1, gas)] + gas[convert(N + 2, gas)]  - cost[convert(N + 2, gas)] + gas[convert(N + 3, gas)]  - cost[convert(N + 3, gas)] + gas[convert(N + 4, gas)] - cost[convert(N + 4, gas)] + gas[convert(N , gas)];
    }*/

}
