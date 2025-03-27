package com.wsb.leetcode.DynamicProgramming;

public class numDistinct_115 {
    public int numDistinct(String s, String t) {
        // dp[i][j]:[0,i-1]的s中有多少个[0,j-1]的t
        /*
        假设 t="bag" 两种转移情况分别为:
         当此元素相等时, 则求s的前面有多少个"ba" + 前面有多少个完整"bag"
         若此元素不相等, 则求s的前面有多少个"bag"
        */
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}
