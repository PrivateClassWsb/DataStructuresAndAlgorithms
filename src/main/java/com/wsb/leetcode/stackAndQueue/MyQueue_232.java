package com.wsb.leetcode.stackAndQueue;

import java.util.Stack;

public class MyQueue_232 {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue_232() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void dumpstackIn(){
        if (!stackOut.isEmpty()){
            return;
        }
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}
