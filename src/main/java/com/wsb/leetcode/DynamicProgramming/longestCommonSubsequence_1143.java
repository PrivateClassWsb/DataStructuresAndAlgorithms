package com.wsb.leetcode.DynamicProgramming;

public class longestCommonSubsequence_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] : [0, i - 1]的text1 和 [0, j - 1]的text2 的最长公共子序列的长度
        // text1 = "abcde"
        // text2 = "ace"
        /*
            i/j 0 1 2 3
            0   0 0 0 0
            1   0 1 1 1
            2   0 1 1 1
            3   0 1 2 2
            4   0 1 2 2
            5   0 1 2 3
         */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int res = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
