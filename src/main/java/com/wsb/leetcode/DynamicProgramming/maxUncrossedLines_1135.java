package com.wsb.leetcode.DynamicProgramming;

public class maxUncrossedLines_1135 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // dp[i][j] : [0, i - 1]的nums1 和 [0, j - 1]的nums2 的最长公共子序列的长度（同1135题）
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
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
