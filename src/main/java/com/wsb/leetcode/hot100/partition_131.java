package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class partition_131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s){
        char[] chars = s.toCharArray();
        int length = chars.length;
        // dp[i][j]：表示区间范围[i,j]（左闭右闭）的子串是否是回文子串.
        dp = new boolean[length + 1][length + 1];
        isPalindrome(chars);
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++){
            if (dp[startIndex][i]){
                path.add(s.substring(startIndex, i + 1));
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }else {
                continue;
            }
        }

    }

    private void isPalindrome(char[] chars) {
        // 由于dp的定义 所以j一定是大于i的 所以只需要填充二维矩阵的上半部分
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]){
                    if (j - i <= 1){
                        dp[i][j] = true;
                    }else {
                        if (dp[i + 1][j - 1]){
                            dp[i][j] = true;
                        }
                    }

                }
            }
        }
    }

    public List<List<String>> partition1(String s){
        backtracking1(s, 0, new StringBuilder());
        return res;
    }

    private void backtracking1(String s, int startIndex, StringBuilder sb) {
        if (startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (check(sb)){
                path.add(sb.toString());
                backtracking1(s, i + 1, new StringBuilder());
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean check(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) return false;
        }
        return true;
    }
}
