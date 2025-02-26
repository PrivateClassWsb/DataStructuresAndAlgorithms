package com.wsb.leetcode.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_225 {

    Queue<Integer> queue= null;

    public MyStack_225() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();
    }

    public int top() {
        rePosition();
        int result = queue.poll();
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private void rePosition(){
        int size = queue.size();
        size--;
        while (size > 0) {
            queue.add(queue.poll());
            size--;
        }
    }
}
