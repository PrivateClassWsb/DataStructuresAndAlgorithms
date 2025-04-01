package com.wsb.leetcode.hot100;

public class maxSubArray_53 {
    // 动态规划
    public int maxSubArray(int[] nums) {
        // dp[i] : nums中前i + 1项的最大连续子数组的和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 贪心
    public int maxSubArray1(int[] nums) {
        int resSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            resSum = Math.max(sum, resSum);
            if (sum < 0) sum = 0;
        }
        return resSum;
    }
}
