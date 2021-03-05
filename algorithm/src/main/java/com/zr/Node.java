package com.zr;

/**
 * @Author zhourui
 * @Date 2021/1/25 16:57
 */
public class Node {

    Node pre;
    Integer gas;
    Integer index;
    Integer cost;
    Node next;

    public Node(Integer gas, Integer index, Integer cost) {
        this.gas = gas;
        this.index = index;
        this.cost = cost;
    }

    public void addNode(Node head, Node node) {
        while (true) {
            if (head.next == null) {
                break;
            }
            head = head.next;
        }
        head.next = node;
        node.pre = head;
    }

    // 查看
    public void list(Node head) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        System.out.println(head);
        Node temp = head.next;
        while (true) {
            // 判断是否到链表最后节点
            if (temp == null) {
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;
        }
    }

    public Node getNode(Node head, int N) {
        if (head.next == null) {
            return null;
        }
        Node temp = head.next;
        while (true) {
            if (temp.index == N) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Node{" +
                "gas=" + gas +
                ", index=" + index +
                ", cost=" + cost +
                '}';
    }

}
