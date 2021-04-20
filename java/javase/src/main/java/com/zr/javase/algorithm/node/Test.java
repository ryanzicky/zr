package com.zr.javase.algorithm.node;

import net.minidev.json.JSONValue;

import java.util.*;

/**
 * @Author zhourui
 * @Date 2021/4/14 13:54
 */
public class Test {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        Tree tree3 = new Tree();
        tree3.setLabel("标签3");
        tree3.setValue(3);

        List<Tree> list2 = new ArrayList<>();
        list2.add(tree3);

        Tree tree2 = new Tree();
        tree2.setLabel("标签2");
        tree2.setValue(2);
        tree2.setChildren(list2);

        List<Tree> list1 = new ArrayList<>();
        list1.add(tree2);

        Tree tree6 = new Tree();
        tree6.setLabel("标签6");
        tree6.setValue(6);

        List<Tree> list4 = new ArrayList<>();


        Tree tree5 = new Tree();
        tree5.setLabel("标签5");
        tree5.setValue(5);

        list4.add(tree5);
        list4.add(tree6);

        Tree tree4 = new Tree();
        tree4.setLabel("标签4");
        tree4.setValue(4);
        tree4.setChildren(list4);


        list1.add(tree4);



        Tree tree1 = new Tree();
        tree1.setLabel("标签1");
        tree1.setValue(1);
        tree1.setChildren(list1);

        System.out.println(tree1.toString());
        System.out.println(JSONValue.toJSONString(tree1));
        parseTree(tree1, map);
        System.out.println(map.toString());
    }

    public static void parseTree(Tree tree, Map<Integer, List<Integer>> map) {
        if (null == tree) {
            return;
        }
        if (null != tree.getChildren() && !tree.getChildren().isEmpty()) {
            for (Tree child : tree.getChildren()) {
                parseTree(child, map);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(tree.getValue());

        map.put(tree.getValue(), list);
    }
}

class Tree {
    String label;
    Integer value;
    List<Tree> children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "label='" + label + '\'' +
                ", value=" + value +
                ", children=" + children +
                '}';
    }
}
