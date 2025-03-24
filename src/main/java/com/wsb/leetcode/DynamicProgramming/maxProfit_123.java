package com.wsb.leetcode.DynamicProgramming;

public class maxProfit_123 {
    public int maxProfit(int[] prices) {
        // dp[i][0] : 第i天 第一次持有该股票所得的最大金额。
        // dp[i][1] : 第i天 第一次不持有该股票所得的最大金额。
        // dp[i][2] : 第i天 第二次持有该股票所得的最大金额。
        // dp[i][3] : 第i天 第二次不持有该股票所得的最大金额。
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0 - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[prices.length - 1][3];
    }
}
