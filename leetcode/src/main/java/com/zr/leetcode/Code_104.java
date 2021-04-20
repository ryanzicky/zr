package com.zr.leetcode;

import com.fasterxml.jackson.core.TreeNode;

/**
 * @Author zhourui
 * @Date 2021/4/14 13:47
 */
public class Code_104 {

    static Node prev = null;

    public static void main(String[] args) {


    }

    public static void flatten(Node root){
        if (root == null) {
            return;
        }
        flatten(root.right); // 先转换右子树
        flatten(root.left); // 后转换左子树

        root.right = prev;
        root.left = null;

        prev = root;
    }
}

class Node {
    public Node node;
    public Node left;
    public Node right;

}
