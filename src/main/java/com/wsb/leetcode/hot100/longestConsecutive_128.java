package com.wsb.leetcode.hot100;

import java.util.HashSet;

public class longestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)){
                int currentLong = 1;
                while (set.contains(num + 1)){
                    num += 1;
                    currentLong++;
                }
                res = Math.max(res, currentLong);
            }
        }
        return res;
    }
}
