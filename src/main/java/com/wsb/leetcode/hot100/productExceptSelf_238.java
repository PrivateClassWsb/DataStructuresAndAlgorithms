package com.wsb.leetcode.hot100;

public class productExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        // 前缀积
        //  左侧没有元素时 answer[0]=1
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // 后缀积
        // 右侧没有元素时 right = 1
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= right; // 这里的right是nums[i]的后缀积
            right = right * nums[i]; // 这里的right计算的是nums[i-1]的后缀积，供下一轮循环使用
        }
        return answer;
    }
}
