package com.wsb.leetcode.hot100;

import java.util.Arrays;

public class lengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i] : nums[0]-nums[i] 的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
