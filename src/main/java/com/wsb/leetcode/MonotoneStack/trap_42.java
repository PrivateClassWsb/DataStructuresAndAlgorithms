package com.wsb.leetcode.MonotoneStack;

import java.util.Deque;
import java.util.LinkedList;

public class trap_42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int middle = stack.pop();
                    if (!stack.isEmpty()){
                        int h = Math.min(height[i], height[stack.peek()]) - height[middle];
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
