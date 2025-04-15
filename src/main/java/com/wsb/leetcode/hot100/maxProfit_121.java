package com.wsb.leetcode.hot100;

public class maxProfit_121 {
    // [7, 1, 5, 3, 6, 4]
    // 贪心
    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // DP
    public int maxProfit(int[] prices) {
        // dp[i][0] : 第i天持有股票所得最多现金
        // dp[i][1] : 第i天不持有股票所得最多现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }
}
