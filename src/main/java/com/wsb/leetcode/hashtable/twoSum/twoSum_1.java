package com.wsb.leetcode.hashtable.twoSum;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum_1 {

    public static int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];

        if (nums == null || nums.length == 0){
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }
}
