package com.wsb.leetcode.hot100;

import java.util.HashMap;

public class twoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // 暴力
    public int[] twoSum1(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
