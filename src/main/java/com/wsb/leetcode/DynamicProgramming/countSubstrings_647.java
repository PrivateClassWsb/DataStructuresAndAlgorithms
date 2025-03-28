package com.wsb.leetcode.DynamicProgramming;

import java.util.Arrays;

public class countSubstrings_647 {
    public int countSubstrings(String s) {
        // dp[i][j] : [i,j]子串是否是回文子串
        // s = "abab"
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1){
                        dp[i][j] = true;
                        res++;
                    }else {
                        if (dp[i + 1][j - 1]){
                            dp[i][j] = true;
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
