package com.zr.javase.algorithm.lfu;

/**
 * @Author zhourui
 * @Date 2021/3/24 14:22
 */
public class Node implements Comparable<Node> {

    Object key; // 键
    Object value; // 值
    long time; // 访问时间
    int count; // 访问次数

    public Node(Object key, Object value, long time, int count) {
        this.key = key;
        this.value = value;
        this.time = time;
        this.count = count;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Node node) {
        int compare = Integer.compare(this.count, node.count);
        // 在数目相同的情况下 比较时间
        if (compare == 0) {
            return Long.compare(this.time, node.time);
        }
        return compare;
    }
}
