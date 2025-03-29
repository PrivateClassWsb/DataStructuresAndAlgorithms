package com.wsb.leetcode.MonotoneStack;

import java.util.Deque;
import java.util.LinkedList;

public class largestRectangleArea_84 {
    public int largestRectangleArea(int[] heights) {
        int[] heights_new = new int[heights.length + 2];
        heights_new[0] = 0;
        heights_new[heights_new.length - 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            heights_new[i + 1] = heights[i];
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < heights_new.length; i++) {
            if (heights_new[i] >= heights_new[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && heights_new[i] < heights_new[stack.peek()]){
                    int middle = stack.pop();
                    int w = i - stack.peek() - 1;
                    int h = heights_new[middle];
                    res = Math.max(h * w, res);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
