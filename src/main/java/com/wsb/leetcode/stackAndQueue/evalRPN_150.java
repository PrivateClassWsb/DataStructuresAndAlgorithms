package com.wsb.leetcode.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class evalRPN_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+")){
                deque.push(deque.pop() + deque.pop());
            }else if (s.equals("-")){
                deque.push(-deque.pop() + deque.pop());
            }else if (s.equals("*")){
                deque.push(deque.pop() * deque.pop());
            }else if (s.equals("/")){
                int temp1 = deque.pop();
                int temp2 = deque.pop();
                deque.push(temp2 / temp1);
            }else {
                deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();
    }
}
