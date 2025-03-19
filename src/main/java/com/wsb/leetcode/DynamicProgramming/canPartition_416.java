package com.wsb.leetcode.DynamicProgramming;

public class canPartition_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
            }
            if (dp[target] == target){
                return true;
            }
        }
        return dp[target] == target;
    }
}
