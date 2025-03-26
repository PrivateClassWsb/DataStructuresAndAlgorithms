package com.wsb.leetcode.DynamicProgramming;

import java.util.Arrays;

public class findLengthOfLCIS_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
