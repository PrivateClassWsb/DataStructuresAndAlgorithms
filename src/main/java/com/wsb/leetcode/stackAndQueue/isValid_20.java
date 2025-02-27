package com.wsb.leetcode.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class isValid_20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '('){
                deque.push(')');
            }else if (ch[i] == '['){
                deque.push(']');
            }else if (ch[i] == '{'){
                deque.push('}');
            }else if (deque.isEmpty() || deque.peek() != ch[i]){
                return false;
            }else {
                deque.pop();
            }
        }
        
        return deque.isEmpty();
    }
}
