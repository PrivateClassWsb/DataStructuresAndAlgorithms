package com.wsb.leetcode.hot100;

public class canPartition_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1]; // dp[i]:容量为i的背包最多能装的最大价值
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                 dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
            }
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}
