package com.zr.leetcode;

/**
 *  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 * @Author zhourui
 * @Date 2021/4/7 19:46
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Code_02 {

    public static void main(String[] args) {
        Code_02 code_02 = new Code_02();
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        System.out.println(code_02.addTwoNumbers(l1, l2).val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode resTemp = res;
        int nextSum = 0;
        int flag = 0; // 标识相加进1
        while(l1 != null && l2 != null){
            int p;
            if(flag == 0){
                p = l1.val + l2.val;
                res.val = p % 10;
                nextSum = p/10;
                flag ++;
            }else{
                p = l1.val + l2.val + nextSum;
                resTemp.next = new ListNode(p % 10);
                resTemp = resTemp.next;
                nextSum = p/10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int p = l1.val + nextSum;
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            nextSum = p / 10;
            l1 = l1.next;
        }
        while(l2 != null){
            int p = (l2.val + nextSum);
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            nextSum = p / 10;
            l2 = l2.next;
        }
        if(nextSum != 0) {
            resTemp.next = new ListNode(nextSum);
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


