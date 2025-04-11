package com.wsb.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class isValid_20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                deque.push(')');
            } else if (c == '[') {
                deque.push(']');
            } else if (c == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || deque.peek() != c) {
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
