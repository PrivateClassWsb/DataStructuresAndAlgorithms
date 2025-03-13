package com.wsb.leetcode.greedy;

public class wiggleMaxLength_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int prediff = 0;
        int curdiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curdiff = nums[i] - nums[i - 1];
            if ((curdiff > 0 && prediff <= 0) || ((curdiff < 0 && prediff >= 0))){
                count++;
                prediff = curdiff;
            }
        }
        return count;
    }
}
