package com.wsb.leetcode.DynamicProgramming;

public class maxProfit_188 {
    public int maxProfit(int k, int[] prices) {
        // dp[i][0] : 第i天 第一次持有该股票所得的最大金额。
        // dp[i][1] : 第i天 第一次不持有该股票所得的最大金额。
        // dp[i][2] : 第i天 第二次持有该股票所得的最大金额。
        // dp[i][3] : 第i天 第二次不持有该股票所得的最大金额。...
        int[][] dp = new int[prices.length][2 * k];
        for (int i = 0; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
            dp[0][i + 1] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                if (j == 0){
                    dp[i][0] = Math.max(dp[i - 1][0], 0 - prices[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                    dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }
}
