package com.wsb.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class largestRectangleArea_84 {
    public int largestRectangleArea(int[] heights) {
        int[] heights_new = new int[heights.length + 2];
        heights_new[0] = 0;
        heights_new[heights_new.length - 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            heights_new[i + 1] = heights[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        stack.push(0);
        for (int i = 1; i < heights_new.length; i++) {
            if (heights_new[i] >= heights_new[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && heights_new[i] < heights_new[stack.peek()]){
                    int middle = stack.pop();
                    int w = i - stack.peek() - 1;
                    int h = heights_new[middle];
                    res = Math.max(w * h, res);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
