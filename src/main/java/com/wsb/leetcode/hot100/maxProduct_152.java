package com.wsb.leetcode.hot100;

public class maxProduct_152 {
    public int maxProduct(int[] nums) {

        int max = nums[0]; // 以当前元素为结尾的子数组能得到的最大乘积
        int min = nums[0]; // 以当前元素为结尾的子数组能得到的最小乘积（因为负数乘负数有可能成为一个更大的正数）
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(nums[i], max * nums[i]), min * nums[i]);
            min = Math.min(Math.min(nums[i], temp * nums[i]), min * nums[i]);
            res = Math.max(res, max);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        maxProduct_152 test = new maxProduct_152();
        test.maxProduct(new int[]{1,0,-5,2,3,-8,-9});
    }
}
/*
       [0, 2, 3, 0]
    i = 0, nums[i] = 0, max = 0, min = 0, res = 0;
    i = 1, nums[i] = 2, max = max(2, 0, 0) = 2, min = min(2, 0, 0) = 0, res = 2;
    i = 2, nums[i] = 3, max = max(3, 6, 0) = 6, min = min(3, 6, 0) = 0, res = 6;
 */