package com.wsb.leetcode.MonotoneStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class nextGreaterElements_503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        stack.push(0);
        for (int i = 0; i < 2 * nums.length; i++) {
            if (nums[i % nums.length] <= nums[stack.peek() % nums.length]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek() % nums.length]){
                    res[stack.peek() % nums.length] = nums[i % nums.length];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
