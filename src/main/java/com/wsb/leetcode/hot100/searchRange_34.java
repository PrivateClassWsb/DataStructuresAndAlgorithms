package com.wsb.leetcode.hot100;

public class searchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int x = leftSearch(nums, target);
        if (x == -1){
            return new int[]{-1, -1};
        }else {
            return new int[]{x, rightSearch(nums, target)};
        }
    }

    private int rightSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int candicate = -1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (target < nums[mid]){
                right = mid - 1;
            }else if (target >nums[mid]){
                left = mid + 1;
            }else {
                candicate = mid;
                left = mid + 1;
            }
        }
        return candicate;
    }


    private int leftSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int candicate = -1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (target < nums[mid]){
                right = mid - 1;
            }else if (target >nums[mid]){
                left = mid + 1;
            }else {
                candicate = mid;
                right = mid - 1;
            }
        }
        return candicate;
    }
}
