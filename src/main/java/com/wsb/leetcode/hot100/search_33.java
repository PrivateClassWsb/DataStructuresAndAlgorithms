package com.wsb.leetcode.hot100;

public class search_33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) return mid;
            if (nums[0] <= nums[mid]){
                if (target >= nums[0] && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target > nums[mid] && target <= nums[nums.length - 1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {5,6,0,1,2,3,4};
        search_33 test = new search_33();
        test.search(num, 2);
    }
}
