package com.wsb.leetcode.greedy;

public class jump_45 {
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int count = 0;
        int curDistance = 0;
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1){
                count++;
                break;
            }
            if (i == curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
