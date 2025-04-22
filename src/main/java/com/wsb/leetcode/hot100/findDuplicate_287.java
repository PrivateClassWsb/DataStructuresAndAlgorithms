package com.wsb.leetcode.hot100;

public class findDuplicate_287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n;
        int res = 0;
        while (l <= r){
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid){
                    cnt++;
                }
            }
            if (cnt <= mid){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
