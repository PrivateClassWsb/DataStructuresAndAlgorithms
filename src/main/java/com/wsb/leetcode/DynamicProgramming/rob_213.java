package com.wsb.leetcode.DynamicProgramming;

import java.util.Arrays;

public class rob_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(rob1(nums1), rob1(nums2));
    }

    private int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
