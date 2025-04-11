package com.wsb.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack() {
        xStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
