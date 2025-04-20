package com.wsb.leetcode.hot100;

public class longestPalindrome_5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len]; // dp[i][j]:s[i..j]是否是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i <= (len - L); i++) {
                int j = i + L - 1;
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if ((j - i) <= 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L > maxLen){
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
