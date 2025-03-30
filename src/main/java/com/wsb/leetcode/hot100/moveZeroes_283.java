package com.wsb.leetcode.hot100;

public class moveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int right = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
