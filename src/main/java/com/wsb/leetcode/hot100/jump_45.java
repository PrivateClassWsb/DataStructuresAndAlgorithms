package com.wsb.leetcode.hot100;

public class jump_45 {
    // [0]
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int res = 0;
        int curDistance = 0;
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1){
                res++;
                break;
            }
            if (i == curDistance){
                curDistance = maxDistance;
                res++;
            }
        }
        return res;
    }
}
