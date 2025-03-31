package com.wsb.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

public class trap_42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]){
                stack.push(i);
            }else if (height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int midlle = stack.pop();
                    if (!stack.isEmpty()){
                        int h = Math.min(height[i], height[stack.peek()]) - height[midlle];
                        int w = i - stack.peek() - 1;
                        res += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
