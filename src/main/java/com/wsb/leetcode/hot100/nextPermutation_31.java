package com.wsb.leetcode.hot100;

public class nextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1){
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[j]){
            i--;
            j--;
        }
        if (i >= 0){
            while (nums[k] <= nums[i]){
                k--;
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        for (int left = j, right = nums.length - 1; left < right; left++, right--){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
