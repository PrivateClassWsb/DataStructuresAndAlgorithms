package com.wsb.leetcode.DynamicProgramming;

public class maxProfit_122 {
    public int maxProfit(int[] prices) {
        // dp[i][0] : 第i天 持有该股票所得的最大金额。包括：当天买入和之前已经买入两种状态
        // dp[i][1] : 第i天 不持有该股票所得的最大金额。包括：当天卖出和之前已经卖出两种状态
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

}
