package com.wsb.leetcode.hot100;

import java.util.Arrays;

public class coinChange_322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i]:凑成总金额i所需的最少的硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        coinChange_322 test = new coinChange_322();
        test.coinChange(new int[]{2}, 3);
    }
}
