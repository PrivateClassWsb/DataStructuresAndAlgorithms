package com.wsb.leetcode.hot100;

import java.util.HashSet;
import java.util.List;

public class wordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        // dp[i]:s中前i字符串是否可以由字典中单词组成 (s[0] - s[i - 1])
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
