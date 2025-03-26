package com.wsb.leetcode.DynamicProgramming;

public class findLength_718 {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j] : 以i - 1为结尾的nums1 和 以j - 1为结尾的nums2 的最大重复子数组长度
        /*
            nums1 : [1, 2, 3, 2, 1]
            nums2 : [3, 2, 1, 4, 7]
            i/j 0 1 2 3 4 5
            0   0 0 0 0 0 0
            1   0 0 0 1 0 0
            2   0 0 1 0 0 0
            3   0 1 0 0 0 0
            4   0 0 2 0 0 0
            5   0 0 0 3 0 0
         */
        int res = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
