package com.wsb.leetcode.hot100;

import java.util.Arrays;

public class numSquares_279 {
    public int numSquares(int n) {
        // dp[i] :和为i的完全平方数的最少数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
