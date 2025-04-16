package com.wsb.leetcode.hot100;

public class rob_198 {
    public int rob(int[] nums) {
        // dp[i][0]:偷
        // dp[i][1]:不偷
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        rob_198 test = new rob_198();
        test.rob(new int[]{2,7,9,3,1});
    }

}
