package com.wsb.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class decodeString_394 {
    public String decodeString(String s) {
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<String> letters = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int number = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c >= '0' && c <= '9'){
                number = number * 10 + Integer.parseInt(String.valueOf(c));
            }else if (c == '['){
                numbers.push(number);
                letters.push(res.toString());
                number = 0;
                res = new StringBuilder();
            }else if (c == ']'){
                String string = res.toString();
                res = new StringBuilder(letters.pop());
                int temp = numbers.pop();
                for (int i = 0; i < temp; i++) {
                    res.append(string);
                }
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
