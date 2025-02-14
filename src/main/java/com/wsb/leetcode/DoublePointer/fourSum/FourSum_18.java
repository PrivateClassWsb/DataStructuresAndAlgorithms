package com.wsb.leetcode.DoublePointer.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] >= 0 && nums[k] > target){
                break;
            }
            if (k > 0 && nums[k] == nums[k-1]){
                continue;
            }
            for (int i = k + 1; i < nums.length; i++) {
                if (nums[k] + nums[i] >= 0 && nums[k] + nums[i] > target){
                    break;
                }
                if (i > k + 1 && nums[i] == nums[i - 1]){
                    continue;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[k] + nums[i] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }

        return result;

    }
}
