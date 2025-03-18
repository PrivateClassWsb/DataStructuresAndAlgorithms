package com.wsb.leetcode.DynamicProgramming;

public class fib_509 {
    public int fib1(int n) {
        if (n < 2) return n;
        return fib1(n - 1) + fib(n - 2);
    }

    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index < n + 1; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }

}
