package com.wsb.leetcode.hot100;

public class firstMissingPositive_41 {
    public int firstMissingPositive(int[] nums){
        // 对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
        // 这是因为如果 [1,N] 都出现了，那么答案是 N+1，否则答案是 [1,N] 中没有出现的最小正整数。
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
