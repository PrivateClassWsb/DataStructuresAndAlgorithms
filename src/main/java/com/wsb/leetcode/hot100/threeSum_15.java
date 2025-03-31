package com.wsb.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class threeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }else{
                    ArrayList<Integer> list = new ArrayList<>(List.of(nums[i], nums[left], nums[right]));
                    res.add(list);
                    right--;
                    left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum_15 test = new threeSum_15();
//        test.threeSum(new int[]{-1,0,1,2,-1,-4});
        test.threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10});
    }
}
