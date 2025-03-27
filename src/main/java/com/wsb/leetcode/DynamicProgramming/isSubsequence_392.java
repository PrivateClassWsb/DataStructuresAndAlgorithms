package com.wsb.leetcode.DynamicProgramming;

public class isSubsequence_392 {
    public boolean isSubsequence1(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int res = dp[0][0];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res == s.length();
    }

    public boolean isSubsequence(String s, String t) {
        // dp[i][j]:[0,i-1]的s中有多少个[0,j-1]的t
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
