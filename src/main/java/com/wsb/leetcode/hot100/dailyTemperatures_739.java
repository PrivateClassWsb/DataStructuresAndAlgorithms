package com.wsb.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class dailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        if (temperatures.length == 1){
            res[0] = 0;
            return res;
        }
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
