package com.wsb.leetcode.binarytree;

public class Node_next {
    public int val;
    public Node_next left;
    public Node_next right;
    public Node_next next;

    public Node_next() {}

    public Node_next(int _val) {
        val = _val;
    }

    public Node_next(int _val, Node_next _left, Node_next _right, Node_next _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
