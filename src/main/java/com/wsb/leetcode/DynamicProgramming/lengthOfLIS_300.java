package com.wsb.leetcode.DynamicProgramming;

import java.util.Arrays;

public class lengthOfLIS_300 {
    public int lengthOfLIS(int[] nums) {
        /*
            dp[i]:以nums[i]为结尾的最长递增子序列的长度

        下标： 0          1       2           3           4           5                       6                                   7
       nums:[10,        9,      2,          5,          3,          7,                      101,                                18]

      dp[i]  1[10]     1[9]    1[2]       2[2, 5]       2[2, 3]     3[2, 5, 7]/[2, 3, 7]    4[2, 5, 7, 101]/[2, 3, 7, 101]      4[2, 5, 7, 18]/[2, 3, 7, 18]
      dp[j]  1          1       1           2           2           3                       4
         */

        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {1,3,6,7,9,4,10,5,6};
        int[] nums = {10,9,2,5,3,7,101,6};
        lengthOfLIS_300 test = new lengthOfLIS_300();
        System.out.println(test.lengthOfLIS(nums));
    }
}
