package com.wsb.leetcode.DynamicProgramming;

import java.util.Arrays;

public class change_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
                System.out.println("背包容量j = " + j + ", " + Arrays.toString(dp));
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        change_518 test = new change_518();
        int[] coins = {1, 2, 5};
        test.change(5, coins);
//        test.change1(5, coins);
    }

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j - coins[i] >= 0)
                    dp[j] += dp[j - coins[i]];
            }
            System.out.println("背包容量j = " + j + ", " + Arrays.toString(dp));
        }
        return dp[amount];
    }
}
