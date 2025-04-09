package com.wsb.leetcode.hot100;

public class searchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return left - 1;
    }
}
