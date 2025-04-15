package com.wsb.leetcode.hot100;

public class canJump_55 {
    // nums = [2,3,1,1,4]
    public boolean canJump(int[] nums) {
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
