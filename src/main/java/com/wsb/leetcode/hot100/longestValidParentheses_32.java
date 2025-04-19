package com.wsb.leetcode.hot100;

public class longestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        // dp[i]:以s[i]为结尾的最长有效括号子串的长度.
        // 注意：必须以 s[i] 结尾。 dp[i] 不是计算 s[0..i] 中的任意有效子串。比如“()(”中 dp[2]=0,而不是2
        int[] dp = new int[s.length()];
        int res = dp[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    if ((i - 2) > 0){
                        dp[i] = 2 + dp[i - 2];
                    }else {
                        dp[i] = 2;
                    }
                }else {
                    if ((i - dp[i - 1]) > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        if ((i - dp[i - 1] - 1) > 0){
                            dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2];
                        }else {
                            dp[i] = 2 + dp[i - 1];
                        }
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
