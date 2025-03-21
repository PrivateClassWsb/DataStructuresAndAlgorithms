package com.wsb.leetcode.DynamicProgramming;

import java.util.Arrays;

public class combinationSum4_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
                System.out.println("背包容量j = " + j + ", " + Arrays.toString(dp));
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        combinationSum4_377 test = new combinationSum4_377();
        int[] nums = {1, 2, 3};
        test.combinationSum4(nums, 4);
    }

}
