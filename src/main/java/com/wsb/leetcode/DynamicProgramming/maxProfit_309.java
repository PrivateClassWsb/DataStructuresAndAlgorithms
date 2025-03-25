package com.wsb.leetcode.DynamicProgramming;

public class maxProfit_309 {
    public int maxProfit(int[] prices) {
        // dp[i][0] 持有
        // dp[i][1] 保持卖出
        // dp[i][2] 卖出（如果把1 2合并为不持有，那么冷冻期的前一天就无法确定它是保持卖出还是当天卖出了，而冷冻期的前一天只能是当天卖出）
        // dp[i][3] 冷冻期
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }
}
